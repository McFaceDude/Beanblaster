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
    private float totalBeanified;

    private float planetCount;
    private float beanification;

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
            //System.out.println("i: "+i+" templist.size: "+ tempList.size());
            //System.out.println(tempList); //entity in the list. Does not have to check the last
                                                        //element because it has already been checks by the other.
            for (int j = i + 1; j < tempList.size() ; j++) {
                //System.out.println("i: "+i+" templist.size: "+ tempList.size());
               // System.out.println(tempList);
                //System.out.println("");
                if ((tempList.get(i) instanceof Player)  && (tempList.get(j) instanceof Projectile)) {
                   // System.out.println("Should not collide(Player Projectile):");
                   // System.out.println("i: "+ tempList.get(i)+" j: "+ tempList.get(j));
                   // System.out.println("");

                    //entityList.get(i).collide(entityList.get(j));
                }
                else if ((tempList.get(i) instanceof Projectile) && (tempList.get(j) instanceof Player)) {
                    //System.out.println("Should not collide(Projectile PLayer):");
                    //System.out.println("i: "+ tempList.get(i)+" j: "+ tempList.get(j));
                    //System.out.println("");
                    //entityList.get(i).collide(entityList.get(j));
                }
                else if ((tempList.get(i) instanceof Projectile) && (tempList.get(j) instanceof Projectile)){
                    //System.out.println("Should not collide(Projectile Projectile):");
                    //System.out.println("i: "+ tempList.get(i)+" j: "+ tempList.get(j));
                    //System.out.println("");
                }

                else {
                    //System.out.println("Collide: ");
                   // System.out.println("i: "+ tempList.get(i)+" j: "+ tempList.get(j));
                    //System.out.println("");
                    tempList.get(i).collide(tempList.get(j));
                }

                //System.out.println("i: "+ entityList.get(i)+" j: "+ entityList.get(j));

            }
        }
    }

    public void draw(Graphics g){

        for (Entity entity : entityList){
            entity.draw(g);
        }
    }


    public void addPlanetStatus(Boolean beanified){
        planetCount += 1;
        if (beanified){
            this.totalBeanified += 1;
        }

        beanification = totalBeanified/planetCount;

    }
    public float getBeanification(){
        return (int)(beanification*100);
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
