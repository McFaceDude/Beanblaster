package Blaster;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-06
 */
public class PlanetManager {

    private Queue<Planet> planetList = new LinkedList<Planet>();
    private ArrayList<Entity> collisionList = new ArrayList<Entity>();

    private static final float PLANET_START_Y = -200; //where the enemy spaceship will start in Y position

    private static final int PLANET_SPAWN_DELAY_MIN = 6; //in seconds
    private static final int PLANET_SPAWN_DELAY_MAX = 9;

    private int displayWidth;
    private EntityManager manager;

    public PlanetManager(EntityManager manager) {

    }

    public void createPlanet() throws SlickException { //for the planets

        Planet planet = PlanetTemporaryBuilder.buildPlanet( PLANET_START_Y, manager);

        while (!canSpawn(planet)) {
            planet.randomisePositionX();
        }
        planetList.add(planet); //adds new enemy to the planet list
    }

    public boolean canSpawn(Planet planet){ //checks if the new planet collides with existing planets

        for (Entity entity : planetList){
            if (planet.intersects(entity)){
                return false;
            }
        }
        return true;
    }

    public void draw(Graphics g){

        for (Entity entity : planetList) {
            entity.draw(g);
        }
    }

    public void update(float deltaTime){
        Planet currentPlanet = planetList.element();

        if(currentPlanet.passedScreen(currentPlanet)){
            planetList.remove();
        }
        for (Planet planet : planetList) {
            planet.update(deltaTime);
            planet.collide(collisionList.get(0));
        }
    }

    public void addToCollisionList(Entity entity){
        collisionList.add(entity);
    }

    public int getPlanetSpawnDelayMin() {
        return PLANET_SPAWN_DELAY_MIN;
    }

    public int getPlanetSpawnDelayMax() {
        return PLANET_SPAWN_DELAY_MAX;
    }
}