package blaster;

import blaster.entity.Entity;
import blaster.entity.Player;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * Created by Samuel on 2016-04-19.
 */
public class EntityManager {

    private ArrayList<Entity> entityList = new ArrayList<Entity>();

    private ArrayList<EntityFactory> factoryList = new ArrayList<>();
    Player player;
    private Input input;


    public EntityManager(int displayWidth, int displayHeight, Input input){
       this.input = input;
    }

    public void init() throws SlickException {
        player = new Player(input, this);
    }

    public void update(float deltaTime) throws SlickException {

        player.update(deltaTime);

        for (EntityFactory entityFactory : factoryList){
            if (entityFactory.wantsToProduce(deltaTime)){
                entityList.add(entityFactory.produce(this));
            }
        }

        ArrayList<Entity> tempList = new ArrayList<>(entityList);

        for (Entity entity : tempList){
            entity.update(deltaTime);
        }
    }

    public void draw(Graphics g){

        player.draw(g);

        for (Entity entity : entityList){
            entity.draw(g);
        }
    }

    public void addEntityFactory(EntityFactory factory){
        factoryList.add(factory);
    }

    public void remove(Entity entity){
        entityList.remove(entity);
    }

    public boolean isSpaceOccupied(Entity asker){
        for (Entity entity : entityList){
            if (entity.intersects(asker)){
                return true;
            }
        }
        return false;
    }
}
