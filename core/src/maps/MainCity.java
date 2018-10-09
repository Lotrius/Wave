package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import characters.Player;
import characters.Warrior;
import wave.Wave;

public class MainCity extends InGameScreen {
	private Wave game;
	private Music music;
	private Sound grass;
	BitmapFont font;

	private MapObjects collisionObjects;

	public MainCity(Wave game, Player player) {
		font = new BitmapFont();
		// Set up parameters
		this.game = game;
		this.player = player;

		// Create new tiled map and get dimensions
		tiledMap = new TmxMapLoader().load("map/MainTown/main_town.tmx");
		mapWH = getMapWH(tiledMap);
		mapRight = mapTop = mapWH * RATIO;

		// Rrrrrrrrrenderer
		renderer = new OrthogonalTiledMapRenderer(tiledMap, RATIO);

		// Starting position
		x = 550;
		y = 600;
		
		// Camera position
		cam.position.x = x;
		cam.position.y = y;
		
		// Get collision objects
		collisionObjects = tiledMap.getLayers().get("Collision-2").getObjects();
		
		// Grass sound effect
		grass = Gdx.audio.newSound(Gdx.files.internal("sounds/grass.ogg"));

		// music = Gdx.audio.newMusic(Gdx.files.internal("Music/cancer.ogg"));
		// music.setVolume(0.1f);
		// music.play();
	}

	protected void checkCollision() {
		// Call checkCollision() in super class
		super.checkCollision(collisionObjects);
	}

	public void changeMap() {
		// If the player tries to take the road to the portal area, dispose of current screen
		// and load portal area
		if (player.getX() <= 0 && player.getY() > 760 && player.getY() < 830
				&& Gdx.input.isKeyPressed(Keys.LEFT)) {
			this.dispose();
			game.setScreen(new PortalArea1(game, player));
		}
	}
 
	@Override
	public void render(float delta) {
		// Exit if ESC pressed
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
		// Set up camera and view
		game.batch.setProjectionMatrix(cam.combined);
		renderer.setView(cam);
		renderer.render();
		
		// Check for collisions or map changes
		checkCollision();
		changeMap();

		// Call the superclass render function to do movement
		super.render(delta);
		player.setX(x);
		player.setY(y);
		player.getBody().setX(x);
		player.getBody().setY(y);

		// Draw player and constantly update
		game.batch.begin();

		game.batch.draw(player.getTexture(), player.getX(), player.getY(),
				PLAYER_WIDTH, PLAYER_HEIGHT);
		font.draw(game.batch, String.format("%.0f", player.getX()),
				player.getX() - 20, player.getY() - 10);
		font.draw(game.batch, String.format("%.0f", player.getY()),
				player.getX() + 20, player.getY() - 10); 
		
		game.batch.end();

	}

	@Override
	public void dispose() {
		// Destroy everything
		// music.dispose();
		// grass.dispose()
	}

}
