package blaster.entity;

import blaster.EntityManager;
import blaster.Main;
import blaster.Vector2D;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-19.
 */
public class Projectile extends Entity{

    private static final float PROJECTILE_RADIUS = 15;
    private static final float PROJECTILE_SPEED = 1.0f;
    private static String PROJECTILE_TEXTURE = "res/Player-Bean-Very-Small.png";
    //private  Vector2D STARTING_POSITION = new Vector2D(500, 400);

    private Vector2D velocity;

    public Projectile(Vector2D position, Vector2D target, EntityManager manager) throws SlickException {

        super(new Image(PROJECTILE_TEXTURE), position, PROJECTILE_RADIUS, manager);
        System.out.println("Projectile constructor");
        Vector2D tempVector = new Vector2D((target.getX() - manager.getPlayer().getPosition().getY()), target.getY() - manager.getPlayer().getPosition().getY()).normalize();
        this.velocity = new Vector2D(tempVector.getX() * PROJECTILE_SPEED, tempVector.getY() * PROJECTILE_SPEED);
        System.out.println(velocity.getX()+" "+ velocity.getY());
        System.out.println(position.getX()+ " "+ position.getY());
    }

    public void update(float deltaTime) {
        super.move(velocity);
       /* if (passedScreen()){
            manager.remove(this);
        }*/
    }

    public boolean passedScreen(){
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
