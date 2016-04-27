package blaster;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel
 * Date: 2013-10-06
 */
public class Main extends StateBasedGame {

    static final int DISPLAY_HEIGHT = 600;
    private static final String GAME_NAME = "Bean Blaster!";
    private static final int DISPLAY_WIDTH = 1000;
    private static final int GAME = 1;

    private Main(String GAME_NAME) {
        super(GAME_NAME);
        this.addState(new Game(GAME));

    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Main(GAME_NAME));
            appgc.setDisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT, false);
            appgc.setTargetFrameRate(60);
            appgc.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static int getDisplayHeight() {
        return DISPLAY_HEIGHT;
    }

    public static int getDisplayWidth() {
        return DISPLAY_WIDTH;
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        this.enterState(GAME);
    }
}
