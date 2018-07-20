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

public class InGameScreen implements Screen{
	protected TiledMap tiledMap;
	protected TiledMapTileLayer mainLayer;
	protected int tileSize;
	protected float mapWH;
	protected float mapRight;
	protected float mapTop;
	
	protected OrthographicCamera cam;
	protected float camHalf;
	
	protected final float RATIO = 1.0f;
	
	protected Viewport viewport;
	protected OrthogonalTiledMapRenderer renderer;
	
	protected InGameScreen() {
		cam = new OrthographicCamera();
		viewport = new FitViewport(Wave.V_WIDTH, Wave.V_HEIGHT, cam);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	
	protected void moveCam(float delta) {
		camHalf = cam.viewportWidth / 2; // Half the size of the camera
		
		// Move cam vertically
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			cam.position.y += Player.SPEED * delta;
			cam.update();
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			cam.position.y -= Player.SPEED * delta;
			cam.update();
		} 
		
		// Move cam horizontally
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			cam.position.x -= Player.SPEED * delta;
			cam.update();
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			cam.position.x += Player.SPEED * delta;
			cam.update();
		}
		
		// Keep cam from moving past borders
		if (cam.position.x < camHalf) {
			cam.position.x = camHalf;
			cam.update();
		} else if (cam.position.x > mapRight - camHalf) {
			cam.position.x = mapRight - camHalf;
			cam.update();
		}
		
		if (cam.position.y < camHalf) {
			cam.position.y = camHalf;
			cam.update();
		} else if (cam.position.y > mapTop - camHalf) {
			cam.position.y = mapTop - camHalf;
			cam.update();
		}
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(float delta) {
		// Move camera
		moveCam(delta);
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
