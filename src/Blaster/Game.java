package blaster;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-11
 */
public class Game extends BasicGameState {   //The state where you play the game

    EntityManager entityManager;
    public Input input;

    public Game (int state) {
        input = new Input(Main.DISPLAY_HEIGHT);
        entityManager = new EntityManager(Main.DISPLAY_WIDTH, Main.DISPLAY_HEIGHT, input);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        EntityFactory planetFactory = new PlanetFactory();

        entityManager.init();
        entityManager.addEntityFactory(planetFactory);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        entityManager.draw(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int milliseconds) throws SlickException {
        float deltaTime = 1f/milliseconds; //converts to seconds from milliseconds
        entityManager.update(deltaTime);
    }

    public int getID() {
        return 1;
    }

}