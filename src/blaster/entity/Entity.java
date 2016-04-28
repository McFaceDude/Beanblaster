package blaster.entity;

import blaster.utility.Circle;
import blaster.utility.Sprite;
import blaster.utility.Updatable;
import blaster.utility.Vector2D;
import blaster.visitor.CollisionElement;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Image;


/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-06
 */
abstract public class Entity extends Sprite implements Updatable, CollisionVisitor, CollisionElement {

    final Vector2D speed;
    final EntityManager manager;
    private final Circle collisionObject; //Hitbox in circle shape


    Entity(Image image, Vector2D position, float radius, EntityManager manager) {
        super(image, position);
        this.manager = manager;
        speed = new Vector2D(0, 0);
        collisionObject = new Circle(radius, position); //Hitbox for the spaceship

    }

    void move(Vector2D speed) {

        this.position.add(speed);
        collisionObject.setPosition(position);
    }

    boolean intersects(Entity other) { //checks if objects intersect

        return collisionObject.intersects(other.collisionObject);
    }

    float getRadius() {
        return collisionObject.getRadius();
    }

    protected void setPosition(Vector2D position) {
        super.setPosition(position);
        collisionObject.setPosition(position);
    }

    void selfDestruct() { //removes the entity from the entityList
        manager.remove(this);
    }

    boolean canSpawn() {
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
