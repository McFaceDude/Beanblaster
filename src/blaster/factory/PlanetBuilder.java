package blaster.factory;

import blaster.entity.EntityManager;
import blaster.entity.Planet;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-18.
 * Interface for the PlanetGenerator class to build a planet.
 */
interface PlanetBuilder {
    Planet buildPlanet(float positionY, EntityManager manager) throws SlickException;
}
