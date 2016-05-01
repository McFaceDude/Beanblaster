package blaster.game;

import blaster.entity.EntityManager;
import blaster.factory.EntityFactory;
import blaster.factory.PlanetFactory;
import blaster.factory.ProjectileFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 * Created by Samuel on 2013-10-11
 * The Game class creates the EntityManager obeject which manages all the entities on the screen.
 * It adds the factories which produces the entities. If you wanted to add a new factory which produces,
 * for example powerups in the game, you would create that factory and then Game would add it to EnityManager.
 * Game calls the update method in EntityManager which upates all the entities so that
 * they can move and spawn and so on.
 */
class Game extends BasicGameState {

    private final EntityManager entityManager;

    Game() {

        Input input = new Input(Main.DISPLAY_HEIGHT);
        entityManager = new EntityManager(input);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        EntityFactory planetFactory = new PlanetFactory();
        EntityFactory projectileFactory = new ProjectileFactory();

        entityManager.init();
        entityManager.addEntityFactory(planetFactory);
        entityManager.addEntityFactory(projectileFactory);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        entityManager.draw(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int milliseconds) throws SlickException {

        float deltaTime = 1.0f / milliseconds; //converts to seconds from milliseconds
        entityManager.update(deltaTime);
    }

    public int getID() {
        return 1;
    }


}