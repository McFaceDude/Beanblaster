package Blaster;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * Created by Samuel on 2016-04-19.
 */
public class EntityManager {

    private ArrayList<Entity> entityList = new ArrayList<Entity>();
    Player player;
    private Input input;
    PlanetManager planetManager;
    double time;


    public EntityManager(int displayWidth, int displayHeight, Input input){
       this.input = input;
    }

    public void init() throws SlickException {
        player = new Player(input, this);
        planetManager = new PlanetManager();
        planetManager.addToCollisionList(player);

    }

    public void update(float deltaTime) throws SlickException {
        time -= deltaTime;

        if (time <= 0){

            planetManager.createPlanet();
            time = planetManager.getPlanetSpawnDelayMin() * Math.random() +
                    planetManager.getPlanetSpawnDelayMax() - planetManager.getPlanetSpawnDelayMin();


        }
        player.update(deltaTime);
        planetManager.update(deltaTime);

    }
    public void draw(Graphics g){
        planetManager.draw(g);
        player.draw(g);



        //for(Entity entity: entityList){
        //    entity.draw(g);
        //}
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
