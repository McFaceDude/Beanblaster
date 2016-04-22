package blaster;


/**
 * Created by Samuel on 2015-07-21.
 */
public class Circle {

    float radius;
    Vector2D position;

    public Circle(float radius, Vector2D position) {
        this.radius = radius;
        this.position = position;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }


    public float getRadius() {

        return radius;
    }

    public Vector2D getPosition(){
        return position;
    }

    public boolean intersects(Circle other) {
        return Vector2D.distance(this.position, other.position) <= this.radius+other.radius;
    }

}
