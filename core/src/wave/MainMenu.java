package wave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import characters.Player;
import characters.Warrior;
import maps.MainCity;

public class MainMenu implements Screen {
	// How many global variables do you think we'll have by the end of this game
	private Wave game;
	private Music music;
	private Texture mainMenuImage, play, playHover, exit, exitHover, options,  optionsHover;
	private Player player;
	private int buttonWidth, buttonHeight, middle;
	BitmapFont font;

	public MainMenu(Wave game) {
		// Game 
		this.game = game;
		
		font = new BitmapFont();

		// Button sizes
		buttonWidth = 150;
		buttonHeight = 65;
		middle = 2;
 
		// Main menu image
		mainMenuImage = new Texture("art/main_menu/wave.jpg");
		play = new Texture("art/main_menu/play.png"); 
		playHover = new Texture("art/main_menu/play_hover.png");
		exit = new Texture("art/main_menu/exit.png");
		exitHover = new Texture("art/main_menu/exit_hover.png");
		options = new Texture("art/main_menu/options.png");
		optionsHover = new Texture("art/main_menu/options_hover.png");

		// Main menu music
		music = Gdx.audio
				.newMusic(Gdx.files.internal("Music/tempIntroSong.ogg"));
		music.setVolume(0.1f);
		music.play();
	}

	public void setGameScreen() {
		// Change game screen to main city if path taken
		this.dispose();
		player = new Warrior("SC", "Warrior", 1);
		game.setScreen(new MainCity(game, player));
	}

	public void drawPlay() {
		int playLocation = 2;
		int playX = Wave.V_WIDTH / middle; 
		int playOffsetX = buttonWidth / middle; 

		int playY = Wave.V_HEIGHT / middle;
		int playOffsetY = buttonHeight / playLocation;

		// If play button is pressed, create a new warrior
		// Then set screen to the main city giving game and player as parameters
		if ((Gdx.input.getX() > playX - playOffsetX)
				&& (Gdx.input.getX() < playX + playOffsetX)
				&& (Gdx.input.getY() > playY - playOffsetY)
				&& (Gdx.input.getY() < playY + playOffsetY)) {
 
			game.batch.draw(playHover, playX - playOffsetX,
					playY - playOffsetY); // Change button color if hovering

			Gdx.input.setInputProcessor(new InputAdapter() { 
				public boolean touchDown(int screenX, int screenY, int pointer,
						int button) {
					if (button == Buttons.LEFT) {
						setGameScreen(); // Change game screen on click
					}
					return true;
				}
			});
		} else {
			game.batch.draw(play, playX - playOffsetX,
					playY - playOffsetY); // Change button color if not hovering
		}
	}
	
	public void drawOptions() {
		float optionsLocation = 2.75f;
		int optionsX = Wave.V_WIDTH / middle;
		int optionsOffsetX = buttonWidth / middle;

		float optionsY = Wave.V_HEIGHT / optionsLocation;
		int optionsOffsetY = buttonHeight / 2;

		// If player clicks options, go to options page
		if ((Gdx.input.getX() > optionsX - optionsOffsetX)
				&& (Gdx.input.getX() < optionsX + optionsOffsetX)
				&& (Gdx.input.getY() > Wave.V_HEIGHT - optionsY - optionsOffsetY)
				&& (Gdx.input.getY() < Wave.V_HEIGHT - optionsY + optionsOffsetY)) {

			game.batch.draw(optionsHover, optionsX - optionsOffsetX,
					optionsY - optionsOffsetY); // Change button color if hovering

			Gdx.input.setInputProcessor(new InputAdapter() {
				public boolean touchDown(int screenX, int screenY, int pointer,
						int button) {
					if (button == Buttons.LEFT) {
						//TODO make options
					}
					return true;
				}
			});
		} else {
			game.batch.draw(options, optionsX - optionsOffsetX, 
					optionsY - optionsOffsetY); // change button color if not hovering
		}
	}

	public void drawExit() {
		int exitLocation = 4;
		int exitX = Wave.V_WIDTH / middle;
		int exitOffsetX = buttonWidth / middle;

		int exitY = Wave.V_HEIGHT / exitLocation;
		int exitOffsetY = buttonHeight / 2;

		// Exit game if clicked
		if ((Gdx.input.getX() > exitX - exitOffsetX)
				&& (Gdx.input.getX() < exitX + exitOffsetX)
				&& (Gdx.input.getY() > Wave.V_HEIGHT - exitY - exitOffsetY)
				&& (Gdx.input.getY() < Wave.V_HEIGHT - exitY + exitOffsetY)) {

			game.batch.draw(exitHover, exitX - exitOffsetX,
					exitY - exitOffsetY); // Change button color if hovering

			Gdx.input.setInputProcessor(new InputAdapter() {
				public boolean touchDown(int screenX, int screenY, int pointer,
						int button) {
					if (button == Buttons.LEFT) {
						Gdx.app.exit(); // Exit
					}
					return true;
				}
			});
		} else {
			game.batch.draw(exit, exitX - exitOffsetX,
					exitY - exitOffsetY); // Change button color if not hovering
		}
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

		// Draw the main menu image
		game.batch.begin();

		game.batch.draw(mainMenuImage, 0, 0, Wave.V_WIDTH, Wave.V_HEIGHT); // Background
		
		// Draw buttons
		drawPlay();
		drawOptions();
		drawExit();

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
