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


    public SuperPlanet(float positionMaxX, float positionY) throws SlickException {

        super(new Image(planetTextures[ThreadLocalRandom.current().nextInt(planetTextures.length)]),
                randomPosition(positionMaxX, positionY, SUPER_PLANET_RADIUS), SUPER_PLANET_RADIUS);   // constructor in Sprite
    }



}
