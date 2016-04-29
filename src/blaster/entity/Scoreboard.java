package blaster.entity;

import blaster.utility.Vector2D;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-26.
 * Scroeboard is the text at the top of the screen which desplays how many planets that have been beanified.
 * It is a entity beacuse it needs to acces the draw method which all entities have. Beacuse it only draws
 * text on the screen, it dows not need a image but beacuse it is a entity it must have a image.
 * The image is drawn outside the screen and is never used.
 */
class Scoreboard extends Entity {

    private static final Vector2D POSITION = new Vector2D(2000, 20);
    private static final float RADIUS = 0;
    private static final String IMAGE = "res/Player-Bean-Small.png";
    private static final int X_POSITION = 350;
    private static final int Y_POSITION = 20;


    Scoreboard(EntityManager manager) throws SlickException {
        super(new Image(IMAGE), POSITION, RADIUS, manager);
    }

    public void update(float deltaTime) {
    }

    @Override
    public void draw(Graphics g) {
        g.drawString("Planets Beanified: " + getManager().getTotalBeanified(), X_POSITION, Y_POSITION);
    }

    @Override
    public void collide(CollisionVisitor collisionVisitor) {
    }
}
