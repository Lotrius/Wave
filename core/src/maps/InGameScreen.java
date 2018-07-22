package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import characters.Player;
import wave.Wave;

public abstract class InGameScreen implements Screen{
	protected TiledMap tiledMap;
	protected int tileSize;
	protected float mapWH;
	protected float mapRight;
	protected float mapTop;
	
	protected OrthographicCamera cam;
	protected float camHalf;
	
	protected final float RATIO = 1.0f;
	
	protected Viewport viewport;
	protected OrthogonalTiledMapRenderer renderer;
	
	protected float x;
	protected float y;
	

	protected final int PLAYER_WIDTH = 20;
	protected final int PLAYER_HEIGHT = 20;
	
	protected InGameScreen() {
		cam = new OrthographicCamera();
		viewport = new FitViewport(Wave.V_WIDTH, Wave.V_HEIGHT, cam);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	
	protected void moveChar(float delta) {
		camHalf = cam.viewportWidth / 2; // Half the size of the camera
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			// Move player and camera
			y += Player.SPEED * delta;
			cam.position.y = y;
			
			// If player goes tries to go above map, stop them
			if (y >= mapTop - PLAYER_HEIGHT) {
				y = mapTop - PLAYER_HEIGHT;
			}
			
			// Stop camera when player goes farther than camera can go
			// Restart when appropriate
			if (y >= mapTop - camHalf) {
				cam.position.y = mapTop - camHalf;
			} else if (cam.position.y <= camHalf) {
				cam.position.y = camHalf;
			}
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			// Move player and camera
			y -= Player.SPEED * delta;
			cam.position.y = y;
			
			// If player goes tries to go below map, stop them
			if (y <= 0) {
				y = 0;
			}
			
			// Stop camera when player goes farther than camera can go
			// Restart when appropriate
			if (y <= camHalf) {
				cam.position.y = camHalf;
			} else if (cam.position.y >= mapTop - camHalf) {
				cam.position.y = mapTop - camHalf;
			}
		} 
		// Move cam horizontally
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			// Move player and camera
			x -= Player.SPEED * delta;
			cam.position.x = x;
			
			// If player goes tries to go to left of map, stop them
			if (x <= 0) {
				x = 0;
			}
			
			// Stop camera when player goes farther than camera can go
			// Restart when appropriate
			if (x >= mapRight - camHalf) {
				cam.position.x = mapRight - camHalf;
			} else if (cam.position.x <= camHalf) {
				cam.position.x = camHalf;
			} 
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			// Move player and camera
			x += Player.SPEED * delta;
			cam.position.x = x;
			
			// If player goes tries to go to right of map, stop them
			if (x >= mapRight - PLAYER_WIDTH) {
				x = mapRight - PLAYER_WIDTH;
			}
			
			// Stop camera when player goes farther than camera can go
			// Restart when appropriate
			if (x <= camHalf) {
				cam.position.x = camHalf;
			} else if (cam.position.x >= mapRight - camHalf) {
				cam.position.x = mapRight - camHalf;
			}
		}
		cam.update();
	}
	
	
	protected float getMapWH(TiledMap map) {
		// Get width/height of map
		TiledMapTileLayer mainLayer = (TiledMapTileLayer) map.getLayers().get("Ground");
		return mainLayer.getWidth() * mainLayer.getTileWidth();  
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(float delta) {
		moveChar(delta);
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
		// TODO Auto-generated method stub
		
	} 
}
