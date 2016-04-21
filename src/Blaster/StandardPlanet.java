package Blaster;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-15
 */
public class StandardPlanet extends Planet {

    private static final String[] planetTextures = {"res/Planet-Small.png", "res/Planet-2-Small.png"};
    private static final int STANDARD_PLANET_RADIUS = 35;

    public StandardPlanet(float positionMaxX, float positionY) throws SlickException {

        super(new Image(planetTextures[ThreadLocalRandom.current().nextInt(planetTextures.length)]),
                randomPosition(positionMaxX, positionY, STANDARD_PLANET_RADIUS), STANDARD_PLANET_RADIUS);   // constructor in Sprite
    }
}
