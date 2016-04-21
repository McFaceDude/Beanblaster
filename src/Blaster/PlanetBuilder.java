package Blaster;

import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-18.
 */
public interface PlanetBuilder {
    Planet buildPlanet(float maxX, float positionY) throws SlickException;
}
