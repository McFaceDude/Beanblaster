package blaster.factory;

import blaster.entity.EntityManager;
import blaster.entity.Planet;
import blaster.entity.StandardPlanet;
import blaster.entity.SuperPlanet;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-18.
 */
class PlanetGenerator {

    private static final PlanetBuilder[] planetBuilders = {PlanetGenerator::buildStandardPlanet, PlanetGenerator::buildSuperPlanet};

    //TODO check this
    private static Planet buildSuperPlanet(float positionY, EntityManager manager) throws SlickException {
        return new SuperPlanet(positionY, manager);
    }

    private static Planet buildStandardPlanet(float positionY, EntityManager manager) throws SlickException {
        return new StandardPlanet(positionY, manager);
    }

    static Planet buildPlanet(EntityManager manager) throws SlickException {

        Planet planet;
        planet = planetBuilders[ThreadLocalRandom.current().nextInt(planetBuilders.length)].buildPlanet(PlanetFactory.PLANET_START_Y, manager);
        return planet;
    }
}
