package wave;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wave extends Game {
	// We love global variables
	public SpriteBatch batch;
	public static final int V_WIDTH = 500;
	public static final int V_HEIGHT = 500;

	@Override
	public void create() {
		// New spritebatch for images
		batch = new SpriteBatch();

		// Set the screen to the main menu
		setScreen(new MainMenu(this));
	}

	@Override
	public void render() {
		super.render(); 
	}

	@Override
	public void dispose() {
	}
}
