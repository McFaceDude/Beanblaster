package blaster.utility;


/**
 * Created by Samuel on 2015-07-21.
 * All the entities have a circle object which is the hitbox for the entity.
 * A Circle can check if it intersects another circle, for the collisions in the game.
 */
public class Circle {

    private final float radius;
    private Vector2D position;

    public Circle(float radius, Vector2D position) {
        this.radius = radius;
        this.position = position;
    }

    public float getRadius() {
        return radius;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public boolean intersects(Circle other) {
        return Vector2D.distance(this.position, other.position) <= this.radius + other.radius;
    }

}
