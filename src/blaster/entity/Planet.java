package blaster.entity;

import blaster.game.Main;
import blaster.utility.Vector2D;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Image;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-17.
 */
public abstract class Planet extends Entity {

    private static final float SPEED = 2.0f;
    private int beanHits = 0;
    private final int ANTI_BEAN_LEVEL;
    private final Image beanImage;

    Planet(Image image, Image beanImage, Vector2D position, float radius, EntityManager manager, int ANTI_BEAN_LEVEL) {
        super(image, position, radius, manager);
        speed.setY(SPEED);
        this.beanImage = beanImage;
        this.ANTI_BEAN_LEVEL = ANTI_BEAN_LEVEL;
        while (!canSpawn()) {
            randomisePositionX();
        }
    }

    static Vector2D randomPosition(float y, float radius) {
        return new Vector2D(((float) Math.random() * (Main.getDisplayWidth() - radius * 2) + radius), y);
    }

    public void update(float deltaTime) {
        super.move(speed);
        if (passedScreen()) {
            selfDestruct();
        }

    }

    private boolean passedScreen() {
        return position.getY() >= Main.getDisplayHeight() + getRadius();
    }

    private void randomisePositionX() {
        setPosition(randomPosition(position.getY(), getRadius()));
    }

    private void changeImage() {
        loadImage(beanImage);
    }

    @Override
    public void collide(CollisionVisitor collisionVisitor) {
        collisionVisitor.visit(this);
    }

    @Override
    public void visit(Projectile projectile) {
        super.visit(projectile);
        if (intersects(projectile)) {
            collisionResponse(projectile);
            projectile.collisionResponse(this);
        }
    }

    @Override
    public void visit(Player player) {
        super.visit(player);
        if (intersects(player)) {
            collisionResponse(player);
            player.collisionResponse(this);
        }
    }

    @Override
    public void collisionResponse(Projectile projectile) {
        super.collisionResponse(projectile);
        beanHits += 1;
        if (beanHits > ANTI_BEAN_LEVEL && beanHits < ANTI_BEAN_LEVEL + 2) {
            manager.addBeanifiedPlanet();

            changeImage();


        }
    }
}
