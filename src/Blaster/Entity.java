package Blaster;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-06
 */
abstract public class Entity extends Sprite implements Updatable{

    protected Vector2D speed;
    private Circle collisionObject; //Hitbox in circle shape
    protected boolean alive;

    public Entity(Image image, Vector2D position, float radius) throws SlickException {
        super(image, position);
        speed = new Vector2D(0,0);
        collisionObject = new Circle(radius, position); //Hitbox for the spaceship
        alive = true; //Changes when colliding with something
    }

    protected void move(Vector2D speed){

        this.position.add(speed);
        collisionObject.setPosition(position);

    }

    public void collide(Entity other){ //removes object if collision
        if (collisionObject.intersects(other.collisionObject)) {
            collisionResponse(other);
            other.collisionResponse(this);
    }
    }
    public boolean intersects(Entity other){ //checks if objects intersect

        if (collisionObject.intersects(other.collisionObject)){
            return true;
        }
        return false;
    }


    public float getRadius(){
        return collisionObject.getRadius();
    }

    @Override
    public void setPosition(Vector2D position) {
        super.setPosition(position);
        collisionObject.setPosition(position);
    }

    protected void collisionResponse(Entity other){}

}
