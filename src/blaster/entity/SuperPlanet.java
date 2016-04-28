package blaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Project: Beanblaster.
 * Created by Samuel on 2016-04-18.
 */
public class SuperPlanet extends Planet {

    private static final String[] planetTextures = {"res/Super-Planet.png"};
    private static final int SUPER_PLANET_RADIUS = 70;
    private static final int ANTI_BEAN_LEVEL = 3;
    private static final String BEAN_IMAGE = "res/Super-Planet-Green.png";

    public SuperPlanet(float positionY, EntityManager manager) throws SlickException {

        super(new Image(planetTextures[ThreadLocalRandom.current().nextInt(planetTextures.length)]), new Image(BEAN_IMAGE),
                randomPosition(positionY, SUPER_PLANET_RADIUS), SUPER_PLANET_RADIUS, manager, ANTI_BEAN_LEVEL);   // constructor in Sprite
    }
}
