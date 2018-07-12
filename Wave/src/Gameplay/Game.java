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
    public static final int mainCity = 1;

    public Game(String gameName) {
        super(gameName);
        this.addState(new OpeningScreen(opening));
        this.addState(new MainCity(mainCity));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(opening).init(gc, this);
        this.getState(mainCity).init(gc, this);
        this.enterState(mainCity);
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
