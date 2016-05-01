package blaster.utility;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


/**
 * Created by Samuel on 2013-10-05
 * The class draws all the images in the game and moves the obejcts.
 * All the entities inherits from Sprite.
 */
public class Sprite {

    protected Vector2D position;
    private Image image = null;
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
            //The position of the image is the width and height divided by 2
            g.drawImage(image, position.getX() - image.getWidth() / 2.0f, position.getY() - image.getHeight() / 2.0f);
        }
    }

    protected Vector2D getPosition() {
        return position;
    }

    protected void setPosition(Vector2D position) {
        this.position = position;
    }

}
