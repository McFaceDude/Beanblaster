package blaster.factory;

import blaster.entity.Entity;
import blaster.entity.EntityManager;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-21.
 * Spawns the planets at a random intervall between the two min and max values.
 * It calls the PlanetGenrator class for poduction of the planets.
 */
public class PlanetFactory implements EntityFactory {

    static final float PLANET_START_Y = -200; //where the enemy spaceship will start in Y position
    private static final int PLANET_SPAWN_DELAY_MIN = 3; //in seconds
    private static final int PLANET_SPAWN_DELAY_MAX = 5;
    private double time;

    @Override
    public boolean wantsToProduce(float deltaTime, Input input) {
        time -= deltaTime;

        if (time <= 0) {
            time = PLANET_SPAWN_DELAY_MIN * Math.random() + PLANET_SPAWN_DELAY_MAX - PLANET_SPAWN_DELAY_MIN;

            return true;
        }
        return false;
    }

    @Override
    public Entity produce(EntityManager manager) throws SlickException {

        return PlanetGenerator.buildPlanet(manager);
    }

    @Override
    public void update(float deltaTime) {

    }
}
