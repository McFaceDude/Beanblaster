package blaster;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-06
 */
public class Vector2D {

    float x;
    float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D(Vector2D vector){
        this(vector.x, vector.y);
    }
    public void add(Vector2D v){
        x += v.getX();
        y += v.getY();
    }

    public Vector2D normalize(){
        float length = getLength();
        if (length == 0){return this; }
        x = x/length;
        y= y/length;
        return this;
    }
    public void lerp(Vector2D target, float step){
        x = (x + step * (target.x - x));
        y = (y + step * (target.y - y));

    }

    //region geters/seters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getLength(){
        return (float)Math.sqrt(x*x+y*y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2D){
            Vector2D other = (Vector2D)obj;

            return this.x == other.x && this.y == other.y;
        }
        return false;
    }

    //endregion

    public static Vector2D zero(){
        return new Vector2D(0,0);
    }

    public static Vector2D diff(Vector2D a, Vector2D b){
        return new Vector2D(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));
    }
    public static float distance(Vector2D a, Vector2D b){
        Vector2D diff = diff(a,b);
        return (float)Math.sqrt(Math.pow(diff.getX(),2)+Math.pow(diff.getY(),2));
    }

    public static Vector2D multiply(Vector2D vector, float value){
        return new Vector2D(vector.x * value, vector.y * value);
    }

    public static Vector2D normalized(Vector2D vector){
        return new Vector2D(vector).normalize();
    }

}


