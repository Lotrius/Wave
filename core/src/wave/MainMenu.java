package wave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import characters.Player;
import characters.Warrior;
import maps.MainCity;

public class MainMenu implements Screen {
	// How many global variables do you think we'll have by the end of this game
	private Wave game;
	private Music music;
	private Texture mainMenuImage;
	Player player;

	public MainMenu(Wave game) {
		// Game
		this.game = game;
		
		// Main menu image
		mainMenuImage = new Texture("art/wave.jpg");
		
		// Main menu music
		music = Gdx.audio.newMusic(Gdx.files.internal("Music/tempIntroSong.ogg"));
		music.setVolume(0.1f);
		music.play(); 
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// Exit if ESC pressed
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
		// If A is pressed, create a new warrior
		// Then set screen to the main city giving game and player as parameters
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.dispose();
			player = new Warrior("SC", "Warrior", 1);
			game.setScreen(new MainCity(game, player));
		}
		
		// Draw the main menu image
		game.batch.begin();
		game.batch.draw(mainMenuImage, 0, 0);
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		music.dispose();
	}

}
