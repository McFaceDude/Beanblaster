package blaster.entity;

import blaster.EntityManager;
import blaster.Main;
import blaster.Vector2D;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-17.
 */
public abstract class Planet extends Entity {

    private static final float SPEED = 2.0f;

    public Planet(Image image, Vector2D position, float radius, EntityManager manager) throws SlickException {
        super(image, position, radius, manager);
        speed.setY(SPEED);
        while (!canSpawn()) {
            randomisePositionX();
        }
    }

    public void update(float deltaTime) {
        super.move(speed);
        if (passedScreen()){
            manager.remove(this);
        }

    }

    public boolean passedScreen(){
        if (position.getY() >= Main.getDisplayHeight() + getRadius()){
            return true;
        }
        return false;
    }

    public void randomisePositionX(){
        setPosition(randomPosition(position.getY(), getRadius()));
    }

    protected static Vector2D randomPosition( float y, float radius){
        return new Vector2D(((float)Math.random()*(Main.getDisplayWidth() - radius*2) + radius), y);
    }
    

}
