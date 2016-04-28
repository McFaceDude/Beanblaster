package blaster.entity;

import blaster.utility.Vector2D;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-26.
 */
class Scoreboard extends Entity {

    private static final Vector2D POSITION = new Vector2D(2000, 20);
    private static final float RADIUS = 0;
    private static final String IMAGE = "res/Player-Bean-Small.png";


    Scoreboard(EntityManager manager) throws SlickException {
        super(new Image(IMAGE), POSITION, RADIUS, manager);
    }

    public void update(float deltaTime) {
    }

    @Override
    public void draw(Graphics g) {
        g.drawString("Planets Beanified: " + manager.getTotalBeanified(), 350, 20);
    }

    @Override
    public void collide(CollisionVisitor collisionVisitor) {
    }
}
