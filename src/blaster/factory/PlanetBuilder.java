package blaster.factory;

import blaster.entity.EntityManager;
import blaster.entity.Planet;
import org.newdawn.slick.SlickException;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-18.
 */
interface PlanetBuilder {
    Planet buildPlanet(float positionY, EntityManager manager) throws SlickException;
}
