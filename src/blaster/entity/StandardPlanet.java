package blaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-15
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
