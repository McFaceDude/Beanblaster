package Blaster;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Samuel on 2016-04-17.
 */
public abstract class Planet extends Entity {

    private static final float SPEED = 2.0f;

    public Planet(Image image, Vector2D position, float radius) throws SlickException {
        super(image, position, radius);
        speed.setY(SPEED);
    }

    public void update(float deltaTime) {
        super.move(speed);
    }

    public boolean passedScreen(Entity entity){
        if (position.getY() >= Main.getDisplayWidth()){
            return true;
        }
        return false;
    }

    public void randomisePositionX(float maxX){
        setPosition(randomPosition(maxX, position.getY(), getRadius()));
    }
    protected static Vector2D randomPosition(float maxX, float y, float radius){
        return new Vector2D(((float)Math.random()*(maxX - radius*2) + radius), y);
    }

}
