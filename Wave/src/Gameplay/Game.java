package Gameplay;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Solomon
 */
public class Game extends StateBasedGame {

    public static final String gameName = "Wave";
    public static final int opening = 0;

    public Game(String gameName) {
        super(gameName);
        this.addState(new OpeningScreen(opening));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(opening).init(gc, this);
        this.enterState(opening);
    }

    public static void main(String[] args) {
        AppGameContainer app;
        try {
            app = new AppGameContainer(new Game(gameName));
            app.setDisplayMode(1920, 1080, true);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
