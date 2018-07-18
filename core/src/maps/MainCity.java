package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;

import wave.Wave;

public class MainCity implements Screen{
	private Wave wave;
	private OrthographicCamera cam;
	private TiledMap tiledMap;
//	private Viewport viewport;
	private OrthogonalTiledMapRenderer renderer;
	
	public MainCity(Wave wave) {
		this.wave = wave;
		cam = new OrthographicCamera();
		tiledMap = new TmxMapLoader().load("map/PortalArea1/portal_area_1.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap, 1/2f);
//		viewport = new FitViewPort(Wave.V_WIDTH, Wave.V_HEIGHT, cam);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	public void update(float delta) {
		if (Gdx.input.isTouched()) {
			cam.translate(Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
			cam.update();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		update(delta);
		renderer.setView(cam);
		renderer.render();
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
		this.dispose();
	}

}
