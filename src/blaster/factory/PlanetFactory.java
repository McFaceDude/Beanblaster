package blaster.factory;

import blaster.entity.Entity;
import blaster.entity.EntityManager;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Gustaf on 2016-04-21.
 */
public class PlanetFactory implements EntityFactory {

    static final float PLANET_START_Y = -200; //where the enemy spaceship will start in Y position
    private static final int PLANET_SPAWN_DELAY_MIN = 3; //in seconds
    private static final int PLANET_SPAWN_DELAY_MAX = 5;
    private double time;

    public PlanetFactory() {

    }

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
