package blaster.entity;

import blaster.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-06
 */
abstract public class Entity extends Sprite implements Updatable, CollisionVisitor, CollisonElement {

    protected Vector2D speed;
    private Circle collisionObject; //Hitbox in circle shape
    protected boolean alive;
    protected EntityManager manager;

    public Entity(Image image, Vector2D position, float radius, EntityManager manager) throws SlickException {
        super(image, position);
        this.manager = manager;
        speed = new Vector2D(0,0);
        collisionObject = new Circle(radius, position); //Hitbox for the spaceship
        alive = true; //Changes when colliding with something
    }

    protected void move(Vector2D speed){

        this.position.add(speed);
        collisionObject.setPosition(position);

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

    public void setPosition(Vector2D position) {
        super.setPosition(position);
        collisionObject.setPosition(position);
    }

    protected void selfDestruct(){ //removes the entity from the entityList
        manager.remove(this);
    }

    protected boolean canSpawn(){
        return !manager.isSpaceOccupied(this);
    }



    @Override
    public void visit(Player player) {
    }

    @Override
    public void visit(Projectile projectile) {
    }

    @Override
    public void visit(Planet planet) {
    }

    @Override
    public void collisionResponse(Projectile projectile) {
    }

    @Override
    public void collisionResponse(Planet planet) {
    }

    @Override
    public void collisionResponse(Player player) {
    }
}
