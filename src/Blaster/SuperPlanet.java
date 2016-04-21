package Blaster;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-18.
 */
public class SuperPlanet extends Planet {


    private static final String[] planetTextures = {"res/Super-Planet.png"};
    private static final int SUPER_PLANET_RADIUS = 70;


    public SuperPlanet( float positionY, EntityManager manager) throws SlickException {

        super(new Image(planetTextures[ThreadLocalRandom.current().nextInt(planetTextures.length)]),
                randomPosition(positionY, SUPER_PLANET_RADIUS), SUPER_PLANET_RADIUS, manager);   // constructor in Sprite
    }



}
