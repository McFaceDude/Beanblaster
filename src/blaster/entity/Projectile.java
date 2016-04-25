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
    private static final float PROJECTILE_SPEED = 4.0f;
    private static String PROJECTILE_TEXTURE = "res/Player-Bean-Very-Small.png";
    //private  Vector2D STARTING_POSITION = new Vector2D(500, 400);

    private Vector2D velocity;

    public Projectile(Vector2D position, Vector2D target, EntityManager manager) throws SlickException {

        super(new Image(PROJECTILE_TEXTURE), position, PROJECTILE_RADIUS, manager);
        //System.out.println(target.getX()+" y: "+ target.getY());

        Vector2D direction = new Vector2D(target).sub(position).normalize();
        System.out.println(direction);


        this.velocity = new Vector2D(direction.getX() * PROJECTILE_SPEED, direction.getY() * PROJECTILE_SPEED);

        //System.out.println(velocity.getX()+" "+ velocity.getY());
        //System.out.println(position.getX()+ " "+ position.getY());
    }

    public void update(float deltaTime) {
        super.move(velocity);
        if (passedScreen()){
            selfDestruct();
        }
    }

    public boolean passedScreen(){
        this.position = getPosition();

        if (position.getY() + PROJECTILE_RADIUS <= 0) {
            return true;
        }
        else if(position.getY() - PROJECTILE_RADIUS >= Main.getDisplayHeight()){
            return true;
        }
        if (position.getX() + PROJECTILE_RADIUS <= 0){
            return true;
        }
        else if (position.getX() - PROJECTILE_RADIUS >= Main.getDisplayWidth()) {
            return true;
        }
        return false;
    }

    @Override
    protected void collisionResponse(Entity other) {
        super.collisionResponse(other);
        //setVisible(false);
        selfDestruct();
    }


}
