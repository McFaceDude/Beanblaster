package blaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-18.
 * SuperPlanet is a Planet and is created by the PlanetGenerator class.
 * It has a standard image and a image for when it has bean "beanified" which means that a projectile
 * has collided with it more times than its ANTI_BEAN_LEVEL.
 * It has twice the radius of the StandardPlanet and a higher ANTI_BEAN_LEVEL.
 */
public class SuperPlanet extends Planet {

    private static final String[] PLANET_TEXTURES = {"res/Super-Planet.png"};
    private static final int SUPER_PLANET_RADIUS = 70;
    private static final int ANTI_BEAN_LEVEL = 3;
    private static final String BEAN_IMAGE = "res/Super-Planet-Green.png";

    public SuperPlanet(float positionY, EntityManager manager) throws SlickException {

        super(new Image(PLANET_TEXTURES[ThreadLocalRandom.current().nextInt(PLANET_TEXTURES.length)]), new Image(BEAN_IMAGE),
                randomPosition(positionY, SUPER_PLANET_RADIUS), SUPER_PLANET_RADIUS, manager, ANTI_BEAN_LEVEL);   // constructor in Sprite
    }
}
