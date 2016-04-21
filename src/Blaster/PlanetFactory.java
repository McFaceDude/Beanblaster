package Blaster;

import org.newdawn.slick.SlickException;

/**
 * Created by Gustaf on 2016-04-21.
 */
public class PlanetFactory implements EntityFactory {

    private static final float PLANET_START_Y = -200; //where the enemy spaceship will start in Y position


    public PlanetFactory(){

    }


    @Override
    public boolean wantsToProduce() {
        return false;
    }

    @Override
    public Entity produce(EntityManager manager) throws SlickException {

        return PlanetTemporaryBuilder.buildPlanet(PLANET_START_Y, manager);
    }

    @Override
    public void update(float deltaTime) {

    }


}
