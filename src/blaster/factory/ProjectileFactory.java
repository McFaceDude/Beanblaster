package blaster.factory;

import blaster.entity.Entity;
import blaster.entity.EntityManager;
import blaster.entity.Projectile;
import blaster.utility.Vector2D;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-24.
 */
public class ProjectileFactory implements EntityFactory {

    private Input input;
    private boolean wasDown;

    public ProjectileFactory() {
        wasDown = false;
    }

    @Override
    public boolean wantsToProduce(float deltaTime, Input input) {
        this.input = input;

        //System.out.println("player position: " +  +"mouseX: "+ input.getMouseX() + "mouseY: "+ input.getMouseY());
        //mousePressed(input);

        boolean isDown = input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);
        boolean isPressed = isDown && !wasDown;
        wasDown = isDown;

        return isPressed;
    }

    @Override
    public Entity produce(EntityManager manager) throws SlickException {

        return new Projectile(new Vector2D(manager.getPlayer().getPosition()), new Vector2D(input.getMouseX(), input.getMouseY()), manager);
    }

    @Override
    public void update(float deltaTime) {
    }
}
