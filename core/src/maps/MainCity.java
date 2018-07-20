package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import characters.Player;
import wave.Wave;

public class MainCity extends InGameScreen{
	private Wave game;
	private Music music;
	
	public MainCity(Wave game) {
		this.game = game;
		tiledMap = new TmxMapLoader().load("map/PortalArea1/portal_area_1.tmx");
		mainLayer = (TiledMapTileLayer) tiledMap.getLayers().get("Ground");
		tileSize = (int) mainLayer.getTileWidth();
		mapWH = mainLayer.getWidth() * tileSize;  
		mapRight = mapTop = mapWH * RATIO;
		
		renderer = new OrthogonalTiledMapRenderer(tiledMap, RATIO);
		
//		music = Gdx.audio.newMusic(Gdx.files.internal("Music/cancer.ogg"));
//		music.setVolume(0.1f);
//		music.play();
	}

	public void update(float delta) {
		// Move based on mouse movement
		if (Gdx.input.isTouched()) {
			cam.translate(Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
			cam.update();
		}
		
		moveCam(delta);
	}
	
	@Override
	public void render(float delta) {
		// Exit if pressed
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
		// Update based on update func
		update(delta);
		
		// Set up camera and view
		game.batch.setProjectionMatrix(cam.combined);
		renderer.setView(cam);
		renderer.render();
	}
	
	@Override
	public void dispose() {
		// Destroy music
		music.dispose();
	}

}
