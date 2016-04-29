package blaster.entity;

import blaster.game.Main;
import blaster.utility.Vector2D;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Image;

/**
 * Created by Samuel on 2016-04-17.
 * Planet is a Entity and different planet types exends this class.
 * This calss has all the fetures that the plnet types have in common like speed.
 * It implements a collisionResponse for projectile beacuse that is the only entity that it has
 * a response to, when colliding with it.
 * If it passed the screen it calls the selfDestruct method in EntityManager which removes it from the
 * entityList.
 */
public abstract class Planet extends Entity {

    private static final float SPEED = 2.0f;
    private int beanHits = 0;
    private final int antiBeanLevel;
    private final Image beanImage;

    Planet(Image image, Image beanImage, Vector2D position, float radius, EntityManager manager, int antiBeanLevel) {
        super(image, position, radius, manager);
        getSpeed().setY(SPEED);
        this.beanImage = beanImage;
        this.antiBeanLevel = antiBeanLevel;
        while (!canSpawn()) {
            randomisePositionX();
        }
    }

    static Vector2D randomPosition(float y, float radius) {
        return new Vector2D(((float) Math.random() * (Main.getDisplayWidth() - radius * 2) + radius), y);
    }

    public void update(float deltaTime) {
        move(getSpeed());
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
        if (beanHits > antiBeanLevel && beanHits < antiBeanLevel + 2) {
            getManager().addBeanifiedPlanet();

            changeImage();


        }
    }
}
