package blaster.utility;


/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2015-07-21.
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

   /* public void setRadius(float radius) {
        this.radius = radius;
    }

    public Vector2D getPosition() {
        return position;
    }
    */
    //TODO check if needed
    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public boolean intersects(Circle other) {
        return Vector2D.distance(this.position, other.position) <= this.radius + other.radius;
    }

}
