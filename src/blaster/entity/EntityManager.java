package blaster.entity;

import blaster.factory.EntityFactory;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Samuel on 2016-04-19.
 * EntityManager is created by the Game class and it manages all the entities in the game.
 * It has a factotyList with all the factories that produces entities and this class adds them to the entityList.
 * EntityManager checks if the entityFactories want to produce any entities and it then updates and draws
 * the produced entities and then collides them with each other. It is then up to the entities to have a
 * collisionresponse depending on what entities it collides with.
 */
public class EntityManager {

    private final List<Entity> entityList = new ArrayList<>();
    private final Collection<EntityFactory> factoryList = new ArrayList<>();
    private final Input input;
    private Player player = null;
    private int totalBeanified;


    public EntityManager(Input input) {
        this.input = input;
    }

    public void init() throws SlickException {
        Scoreboard scoreboard = new Scoreboard(this);
        player = new Player(input, this);
        entityList.add(player);
        entityList.add(scoreboard);

    }

    public void update(float deltaTime) throws SlickException {

        for (EntityFactory entityFactory : factoryList) {

            if (entityFactory.wantsToProduce(deltaTime, input)) {
                entityList.add(entityFactory.produce(this));
            }
        }

        List<Entity> tempList = new ArrayList<>(entityList); //Because a entity can remove itself from
        // the entityList when the for loop is running, we need to iterate through a copy of that list

        for (Entity entity : tempList) {
            entity.update(deltaTime);
        }

        for (int i = 0; i < tempList.size(); i++) {  //Checks if any entity in the list collides with any other
            //entity in the list
            for (int j = i + 1; j < tempList.size(); j++) {
                tempList.get(i).collide(tempList.get(j));
            }
        }
    }

    public void draw(Graphics g) {

        for (Entity entity : entityList) {
            entity.draw(g);
        }
    }

    void addBeanifiedPlanet() {
        this.totalBeanified += 1;
    }

    int getTotalBeanified() {
        return totalBeanified;
    }


    public void addEntityFactory(EntityFactory factory) {
        factoryList.add(factory);
    }

    void remove(Entity entity) {
        entityList.remove(entity);
    }

    boolean isSpaceOccupied(Entity asker) {
        for (Entity entity : entityList) {
            if (entity.intersects(asker)) {
                return true;
            }
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }
}

