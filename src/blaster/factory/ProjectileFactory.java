package blaster.factory;

import blaster.entity.Entity;
import blaster.entity.EntityManager;
import blaster.entity.Projectile;
import blaster.utility.Vector2D;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-24.
 * The ProjectileFactory produces a projectile when the mouse button has been clicked.
 * It impelemnts EntityFactory beacuse it is a factory.
 */
public class ProjectileFactory implements EntityFactory {

    private Input input = null;
    private boolean wasDown;

    public ProjectileFactory() {
        wasDown = false;
    }

    @Override
    public boolean wantsToProduce(float deltaTime, Input input) {
        this.input = input;

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
