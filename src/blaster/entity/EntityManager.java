package blaster.entity;

import blaster.factory.EntityFactory;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-19.
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

