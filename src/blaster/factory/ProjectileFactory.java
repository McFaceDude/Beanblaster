package blaster.factory;

import blaster.EntityManager;
import blaster.Vector2D;
import blaster.entity.Entity;
import blaster.entity.Projectile;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-24.
 */
public class ProjectileFactory implements EntityFactory {


    Input input;

    public ProjectileFactory() {

    }

    @Override
    public boolean wantsToProduce(float deltaTime, Input input) {
        this.input = input;
        //System.out.println("player position: " +  +"mouseX: "+ input.getMouseX() + "mouseY: "+ input.getMouseY());
        if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
          //  System.out.println("BUTTON PRESSED!");

            return true;
        }
        //System.out.println("......");
        return false;

    }

    @Override
    public Entity produce(EntityManager manager) throws SlickException {

        //System.out.println("player position: " + manager.getPlayer().getPosition()+" positionX: "+
          //      manager.getPlayer().getPosition().getX()+" positionY: "+ manager.getPlayer().getPosition().getY()+
            //    " mouseX: "+ input.getMouseX() + " mouseY: "+ input.getMouseY());


        return new Projectile(new Vector2D(manager.getPlayer().getPosition()), new Vector2D(input.getMouseX(), input.getMouseY()), manager);

    }

    @Override
    public void update(float deltaTime) {

    }


}
