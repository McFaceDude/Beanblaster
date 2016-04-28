package blaster.entity;

import blaster.game.Main;
import blaster.utility.Vector2D;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-19.
 */
public class Projectile extends Entity {

    private static final float PROJECTILE_RADIUS = 15;
    private static final float PROJECTILE_SPEED = 6.0f;
    private static final String PROJECTILE_TEXTURE = "res/Player-Bean-Very-Small.png";
    private Vector2D velocity;

    public Projectile(Vector2D position, Vector2D target, EntityManager manager) throws SlickException {

        super(new Image(PROJECTILE_TEXTURE), position, PROJECTILE_RADIUS, manager);
        Vector2D direction = new Vector2D(target).sub(position).normalize();
        this.velocity = new Vector2D(direction.getX() * PROJECTILE_SPEED, direction.getY() * PROJECTILE_SPEED);
    }

    public void update(float deltaTime) {
        move(velocity);
        if (passedScreen()) {
            selfDestruct();
        }
    }

    private boolean passedScreen() {
        this.position = getPosition();

        if (position.getY() + PROJECTILE_RADIUS <= 0 || position.getY() - PROJECTILE_RADIUS >= Main.getDisplayHeight()) {
            return true;
        }
        if (position.getX() + PROJECTILE_RADIUS <= 0 || position.getX() - PROJECTILE_RADIUS >= Main.getDisplayWidth()) {
            return true;
        }
        return false;
    }

    @Override
    public void collide(CollisionVisitor collisionVisitor) {
        collisionVisitor.visit(this);
    }

    @Override
    public void visit(Planet planet) {
        super.visit(planet);
        if (intersects(planet)) {
            collisionResponse(planet);
            planet.collisionResponse(this);
        }
    }

    @Override
    public void collisionResponse(Planet planet) {
        super.collisionResponse(planet);
        selfDestruct();
    }
}
