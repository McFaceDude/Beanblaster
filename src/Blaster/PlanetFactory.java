package Blaster;

import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-18.
 */
public class PlanetFactory {

    private static PlanetBuilder[] planetBuilders = {(x,y)->buildStandardPlanet(x,y), (x,y)->buildSuperPlanet(x, y)};

    public static Planet buildSuperPlanet(float maxX, float positionY) throws SlickException{
        return new SuperPlanet(maxX, positionY);
    }

    public static Planet buildStandardPlanet(float maxX, float positionY) throws SlickException{
        return new StandardPlanet(maxX, positionY);
    }

    public static Planet buildPlanet(float maxX, float positionY) throws SlickException{ //return one of the planets

        Planet planet;
        planet = planetBuilders[ThreadLocalRandom.current().nextInt(planetBuilders.length)].buildPlanet(maxX, positionY);
        return planet;
    }
}
