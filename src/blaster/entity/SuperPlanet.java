package blaster.entity;

import blaster.EntityManager;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-18.
 */
public class SuperPlanet extends Planet {


    private static final String[] planetTextures = {"res/Super-Planet.png"};
    private static String BEAN_IMAGE= "res/Green-Super-Planet.png";
    private static final int SUPER_PLANET_RADIUS = 70;
    private static final int ANTI_BEAN_LEVEL = 5;


    public SuperPlanet( float positionY, EntityManager manager) throws SlickException {

        super(new Image(planetTextures[ThreadLocalRandom.current().nextInt(planetTextures.length)]), new Image(BEAN_IMAGE),
                randomPosition(positionY, SUPER_PLANET_RADIUS), SUPER_PLANET_RADIUS, manager, ANTI_BEAN_LEVEL);   // constructor in Sprite
    }





}
