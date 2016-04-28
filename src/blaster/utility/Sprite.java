package blaster.utility;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-05
 */
abstract public class Sprite implements Drawable { //for the moving and drawing of objects on the screen

    protected Vector2D position;
    private Image image;
    private final boolean visible;

    protected Sprite(Image image, Vector2D position) {
        loadImage(image);
        this.position = position;
        visible = true;
    }

    protected void loadImage(Image image) {
        this.image = image;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.drawImage(image, position.getX() - image.getWidth() / 2f, position.getY() - image.getHeight() / 2f);
        }
    }

    protected Vector2D getPosition() {
        return position;
    }

    protected void setPosition(Vector2D position) {
        this.position = position;
    }

    /*public void setVisible(boolean visible) {
        this.visible = visible;
    }*/
    //TODO check if needed

}
