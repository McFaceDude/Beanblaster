package blaster.factory;

import blaster.entity.EntityManager;
import blaster.entity.Planet;
import blaster.entity.StandardPlanet;
import blaster.entity.SuperPlanet;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-18.
 * The PlanetGenerator randomized between spwan methods to build the different types of planets and
 * returns that planet. New planets can easily be added by adding a spawn method for them here.
 */
final class PlanetGenerator {

    private static final PlanetBuilder[] PLANET_BUILDERS = {PlanetGenerator::buildStandardPlanet, PlanetGenerator::buildSuperPlanet};

    private PlanetGenerator() {
    }

    //TODO check this
    private static Planet buildSuperPlanet(float positionY, EntityManager manager) throws SlickException {
        return new SuperPlanet(positionY, manager);
    }

    private static Planet buildStandardPlanet(float positionY, EntityManager manager) throws SlickException {
        return new StandardPlanet(positionY, manager);
    }

    static Planet buildPlanet(EntityManager manager) throws SlickException {

        Planet planet;
        planet = PLANET_BUILDERS[ThreadLocalRandom.current().nextInt(PLANET_BUILDERS.length)].buildPlanet(PlanetFactory.PLANET_START_Y, manager);
        return planet;
    }
}
