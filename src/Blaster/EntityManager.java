package blaster;

import blaster.entity.Entity;
import blaster.entity.Player;
import blaster.entity.Projectile;
import blaster.entity.Scoreboard;
import blaster.factory.EntityFactory;
import blaster.factory.PlanetFactory;
import blaster.factory.ProjectileFactory;
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
    private Input input;
    Player player;
    Scoreboard scoreboard;
    private int totalBeanified;


    public EntityManager(Input input){
       this.input = input;
    }

    public void init() throws SlickException {
        scoreboard = new Scoreboard(this);
        player = new Player(input, this);
        entityList.add(player);
        entityList.add(scoreboard);

    }

    public void update(float deltaTime) throws SlickException {

        for (EntityFactory entityFactory : factoryList){
            //System.out.println(factoryList);
            if (entityFactory.wantsToProduce(deltaTime, input)){
                entityList.add(entityFactory.produce(this));
            }
        }
        //System.out.println(entityList);
        //System.out.println("");
        ArrayList<Entity> tempList = new ArrayList<>(entityList); //Because a entity can remove itself from
        // the entityList when the for loop is running, we need to iterate through a copy of that list

        for (Entity entity: tempList){
            //System.out.println(tempList);
            entity.update(deltaTime);
        }

        for (int i = 0; i < tempList.size() ; i++){  //Checks if any entity in the list collides with any other
                                                     //entity in the list
            for (int j = i + 1; j < tempList.size() ; j++) {

                if ((tempList.get(i) instanceof Player)  && (tempList.get(j) instanceof Projectile)) {}
                else if ((tempList.get(i) instanceof Projectile) && (tempList.get(j) instanceof Player)) {}
                else if ((tempList.get(i) instanceof Projectile) && (tempList.get(j) instanceof Projectile)) {}
                else {
                    tempList.get(i).collide(tempList.get(j));
                }
            }
        }
    }

    public void draw(Graphics g){

        for (Entity entity : entityList){
            entity.draw(g);
        }
    }

    public void addBeanifiedPlanet(){
        this.totalBeanified += 1;

    }
    public int getBeanification(){
        return totalBeanified;
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
    public Player getPlayer(){
        return player;
    }
}
