package blaster.entity;

import blaster.EntityManager;
import blaster.Main;
import blaster.Vector2D;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-17.
 */
public abstract class Planet extends Entity {

    private static final float SPEED = 3.0f;
    private int beanHits = 0;
    private int ANTI_BEAN_LEVEL;
    private Image beanImage;

    public Planet(Image image, Image beanImage, Vector2D position, float radius, EntityManager manager, int ANTI_BEAN_LEVEL) throws SlickException {
        super(image, position, radius, manager);
        speed.setY(SPEED);
        this.beanImage = beanImage;
        this.ANTI_BEAN_LEVEL = ANTI_BEAN_LEVEL;
        while (!canSpawn()) {
            randomisePositionX();
        }
    }

    public void update(float deltaTime) {
        super.move(speed);
        if (passedScreen()){
           selfDestruct();
        }

    }

    public boolean passedScreen(){
        if (position.getY() >= Main.getDisplayHeight() + getRadius()){
            return true;
        }
        return false;
    }

    public void randomisePositionX(){
        setPosition(randomPosition(position.getY(), getRadius()));
    }

    protected static Vector2D randomPosition( float y, float radius){
        return new Vector2D(((float)Math.random()*(Main.getDisplayWidth() - radius*2) + radius), y);
    }

    @Override
    protected void collisionResponse(Entity other) {
        super.collisionResponse(other);
        beanHits += 1;
        if (beanHits == ANTI_BEAN_LEVEL){
            beanHits = 0;
            try {
                changeImage();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }

    }
    private void changeImage() throws SlickException {
        loadImage(beanImage);
    }


}
