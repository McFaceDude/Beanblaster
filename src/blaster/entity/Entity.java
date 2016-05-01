package blaster.entity;

import blaster.utility.Circle;
import blaster.utility.Sprite;
import blaster.utility.Updatable;
import blaster.utility.Vector2D;
import blaster.visitor.CollisionElement;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Image;


/**
 * Created by Samuel 2013-10-06
 * Entity extends sprite because all the entities can be drawn on the screen.
 * All the entities have a Circle which is the hitbox for the entity. It is used for collison.
 * It implements Updatable beacuse it has to have a update method. It impelemnts CollisonVisitor and
 * CollisionElement as part of the visitor design pattern. All the visit and collsionResponse methods
 * are implemented as empty here in Entity and if for example, the Entity Planet can be visited by a
 * pejectile, then planet will implement the visit method for projectile and override the empty method here.
 * Entities takes the EnityManager as a parameter so that all the entities knows who manages them.
 * Entity can use this to selfDestruct which removes the entity from the entityList in the manager.
 */
abstract public class Entity extends Sprite implements Updatable, CollisionVisitor, CollisionElement {

    private final Vector2D speed;
    private final EntityManager manager;
    private final Circle collisionObject; //Hitbox in circle shape


    Entity(Image image, Vector2D position, float radius, EntityManager manager) {
        super(image, position);
        this.manager = manager;
        speed = new Vector2D(0, 0);
        collisionObject = new Circle(radius, position);
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

    public Vector2D getSpeed() {
        return speed;
    }

    public EntityManager getManager() {
        return manager;
    }

    //The methods are not abstract because they are not implemented in all entities, the entites only have
    //collison responses for some of the other entities but not all of them.
    //They are also only visited by some entities and not all of them.

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
    public void collisionResponse(Player player){
    }


}
