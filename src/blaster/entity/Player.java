package blaster.entity;

import blaster.game.Main;
import blaster.utility.Vector2D;
import blaster.visitor.CollisionVisitor;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2013-10-06.
 * Player is an Entity.
 * Player moves withe the arrow buttons and its movment is constrained to the size of the screen.
 * It has a collisonResponse for colliding with planet, it then "dies" and respawns at the respawn position.
 */
public class Player extends Entity {

    private static final float MAX_SPEED = 4.0f;
    private static final float ACCELERATION = 2.0f;
    private static final float FRICTION = 0.7f; //always <1

    private static final Vector2D STARTING_POSITION = new Vector2D(500, 400); //where the player spaceship will start
    private static final Vector2D RESPAWN_POSITION = new Vector2D(STARTING_POSITION.getX(), STARTING_POSITION.getY());
    private static final float PLAYER_RADIUS = 50; //Radius of player

    private static final String PLAYER_TEXTURE = "res/Player-Bean-Small.png";
    private Input input;
    private Vector2D speed;

    public Player(Input input, EntityManager manager) throws SlickException {
        super(new Image(PLAYER_TEXTURE), STARTING_POSITION, PLAYER_RADIUS, manager);
        this.input = input;
        speed = Vector2D.zero();
    }

    @Override
    public void update(float deltaTime) {
        Vector2D direction = Vector2D.zero();

        if (input.isKeyDown(Input.KEY_UP)) {
            direction.setY(-1);
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            direction.setY(1);
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            direction.setX(-1);
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            direction.setX(1);
        }

        if (direction.equals(Vector2D.zero())) {
            speed.lerp(Vector2D.zero(), FRICTION * deltaTime);
        } else {
            direction.normalize();
            speed.add(Vector2D.multiply(direction, ACCELERATION * deltaTime));
        }
        if (speed.getLength() > MAX_SPEED) {
            Vector2D currentDirection = Vector2D.normalized(speed);
            speed = Vector2D.multiply(currentDirection, MAX_SPEED);
        }
        move(speed);
        constrainToScreen();

    }

    private void constrainToScreen() { //Moves the player inside the screen if outside of the bound

        if (position.getY() <= 0 + PLAYER_RADIUS) {
            position.setY(0 + PLAYER_RADIUS);
        } else if (position.getY() >= Main.getDisplayHeight() - PLAYER_RADIUS) {
            position.setY(Main.getDisplayHeight() - PLAYER_RADIUS);
        }
        if (position.getX() <= 0 + PLAYER_RADIUS) {
            position.setX(0 + PLAYER_RADIUS);
        } else if (position.getX() >= Main.getDisplayWidth() - PLAYER_RADIUS) {
            position.setX(Main.getDisplayWidth() - PLAYER_RADIUS);
        }
    }

    public Vector2D getPosition() {
        return this.position;
    }

    private void respawn() {
        Vector2D temp = new Vector2D(RESPAWN_POSITION);
        setPosition(temp);
    }

    @Override
    public void collide(CollisionVisitor collisionVisitor) {
        collisionVisitor.visit(this);
    }

    @Override
    public void collisionResponse(Planet planet) {
        super.collisionResponse(planet);
        respawn();
    }

    @Override
    public void visit(Planet planet) {
        super.visit(planet);
        if (intersects(planet)) {
            collisionResponse(planet);
            planet.collisionResponse(this);

        }
    }
}
