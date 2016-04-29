package blaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2013-10-15
 * StandardPlanet is a Planet and is created by the PlanetGenerator class.
 * It has a standard image and a image for when it has bean "beanified" which means that a projectile
 * has collided with it more times than its ANTI_BEAN_LEVEL.
 */
public class StandardPlanet extends Planet {

    private static final String[] PLANET_TEXTURES = {"res/Planet-2-Small.png"};
    private static final int STANDARD_PLANET_RADIUS = 35;
    private static final int ANTI_BEAN_LEVEL = 1;
    private static final String BEAN_IMAGE = "res/Planet-2-Small-Green.png";

    public StandardPlanet(float positionY, EntityManager manager) throws SlickException {

        super(new Image(PLANET_TEXTURES[ThreadLocalRandom.current().nextInt(PLANET_TEXTURES.length)]), new Image(BEAN_IMAGE),
                randomPosition(positionY, STANDARD_PLANET_RADIUS), STANDARD_PLANET_RADIUS, manager, ANTI_BEAN_LEVEL);   // constructor in Sprite
    }
}
