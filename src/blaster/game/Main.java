package blaster.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Samuel on 2013-10-06
 * The main class for the project. Uses the slick library and extends StateBasedGame in slick.
 * Main calls the game class which "starts up" the game.
 * The Main class sets the size of the window in which the game is played.
 */
public final class Main extends StateBasedGame {

    static final int DISPLAY_HEIGHT = 600;
    private static final int DISPLAY_WIDTH = 1000;
    private static final int GAME = 1;
    private static final int FRAME_RATE = 60;

    private Main(String gameName) {
        super(gameName);
        this.addState(new Game());

    }

    public static void main(String[] args) {
        try {
            String gameName = "Bean Blaster!";
            AppGameContainer appgc = new AppGameContainer(new Main(gameName));
            appgc.setDisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT, false);
            appgc.setTargetFrameRate(FRAME_RATE);
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

    public void initStatesList(GameContainer gc) {
        this.enterState(GAME);
    }
}
