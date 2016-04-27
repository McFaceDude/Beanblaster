package blaster;

import blaster.entity.Planet;
import blaster.entity.StandardPlanet;
import blaster.entity.SuperPlanet;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-18.
 */
public class PlanetGenerator {

    private static PlanetBuilder[] planetBuilders = {(y, manager) -> buildStandardPlanet(y, manager), (y, manager) -> buildSuperPlanet(y, manager)};

    private static Planet buildSuperPlanet(float positionY, EntityManager manager) throws SlickException {
        return new SuperPlanet(positionY, manager);
    }

    private static Planet buildStandardPlanet(float positionY, EntityManager manager) throws SlickException {
        return new StandardPlanet(positionY, manager);
    }

    public static Planet buildPlanet(float positionY, EntityManager manager) throws SlickException { //return one of the planets

        Planet planet;
        planet = planetBuilders[ThreadLocalRandom.current().nextInt(planetBuilders.length)].buildPlanet(positionY, manager);
        return planet;
    }
}
