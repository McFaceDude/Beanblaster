package blaster.entity;

import blaster.EntityManager;
import blaster.Main;
import blaster.Vector2D;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Gustaf on 2016-04-19.
 */
public class Projectile extends Entity{

    private static final float PROJECTILE_RADIUS = 15;
    private static final float PROJECTILE_SPEED = 6.0f;
    private static String PROJECTILE_TEXTURE = "res/Player-Bean-Very-Small.png";
    //private  Vector2D STARTING_POSITION = new Vector2D(500, 400);

    private Vector2D velocity;

    public Projectile(Vector2D position, Vector2D direction, EntityManager manager) throws SlickException {
        super(new Image(PROJECTILE_TEXTURE), position, PROJECTILE_RADIUS, manager);

        this.velocity = new Vector2D(direction.getX() * PROJECTILE_SPEED, direction.getY() * PROJECTILE_SPEED);
    }

    public void update(float deltaTime) {
        super.move(velocity);
    }

    public boolean passedScreen(Entity entity){
        this.position = getPosition();

        if (position.getY() - PROJECTILE_RADIUS <= 0) {
            return true;
        }
        else if(position.getY() + PROJECTILE_RADIUS >= Main.getDisplayHeight()){
            return true;
        }
        if (position.getX()- PROJECTILE_RADIUS <= 0){
            return true;
        }
        else if (position.getX() + PROJECTILE_RADIUS >= Main.getDisplayWidth()) {
            return true;
        }
        return false;
    }

}
