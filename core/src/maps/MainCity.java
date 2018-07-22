package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import characters.Player;
import characters.Warrior;
import wave.Wave;

public class MainCity extends InGameScreen{
	private Wave game;
	private Music music;
	private Player player;
	
	public MainCity(Wave game , Player player) {
		// Set up parameters
		this.game = game;
		this.player = player;
		
		// Create new tiled map and get dimensions
		tiledMap = new TmxMapLoader().load("map/PortalArea1/portal_area_1.tmx");
		mapWH = getMapWH(tiledMap);
		mapRight = mapTop = mapWH * RATIO;
		
		// Rrrrrrrrrenderer
		renderer = new OrthogonalTiledMapRenderer(tiledMap, RATIO);
		
		// Starting position
		x = 30;
		y = 40;
		
//		music = Gdx.audio.newMusic(Gdx.files.internal("Music/cancer.ogg"));
//		music.setVolume(0.1f);
//		music.play();
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

		// Call the superclass render function to do movement
		super.render(delta);
		
		// Draw player and constantly update
		game.batch.begin();
		game.batch.draw(player.getTexture(), x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
		game.batch.end();

	}
	
	@Override
	public void dispose() {
		// Destroy music
		music.dispose();
	}

}
