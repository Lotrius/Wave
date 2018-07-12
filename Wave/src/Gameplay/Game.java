package Gameplay;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Solomon
 */
public class Game extends StateBasedGame{
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer((org.newdawn.slick.Game) new GameSetUp("Wave"));
        app.setDisplayMode(1920, 1080, true);
        app.start();
    }

    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
