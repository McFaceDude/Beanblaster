package blaster;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-05
 */
abstract public class Sprite implements Drawable{ //for the moving and drawing of objects on the screen

    private Image image;
    protected Vector2D position;
    private boolean visible;

    public Sprite(Image image, Vector2D position) throws SlickException {
        loadImage(image);
        this.position = position;
        visible = true;
    }

    public void loadImage(Image image) throws SlickException {
        this.image = image;
    }

    public void draw(Graphics g){
        if (visible) {
            g.drawImage(image, position.getX() - image.getWidth() / 2f, position.getY() - image.getHeight() / 2f);
        }
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
