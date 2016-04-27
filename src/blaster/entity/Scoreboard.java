package blaster.entity;

import blaster.EntityManager;
import blaster.Vector2D;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-26.
 */
public class Scoreboard extends Entity{

    private static final Vector2D POSITION = new Vector2D(2000, 20);
    private static final float RADIUS = 0;
    private static String IMAGE = "res/Player-Bean-Small.png" ;


    public Scoreboard(EntityManager manager) throws SlickException {
        super(new Image(IMAGE), POSITION, RADIUS, manager);
    }

    public void update(float deltaTime) {

    }
    @Override
    public void draw(Graphics g){

        g.drawString("Planets Beanified: " +manager.getBeanification(), 350, 20);

    }



}
