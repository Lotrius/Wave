package wave;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wave extends Game {
	// We love global variables
	public SpriteBatch batch;
	public static final int V_WIDTH = 550;
	public static final int V_HEIGHT = 550;

	@Override
	public void create() {
		// New spritebatch for images
		batch = new SpriteBatch(); 

		// Set the screen to the main menu
		setScreen(new MainMenu(this));
	}

	@Override
	public void render() {
		// Call render in super class
		super.render();
	}

	@Override
	public void dispose() {
	}
}
