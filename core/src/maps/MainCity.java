package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import wave.Wave;

public class MainCity implements Screen{
	private Wave game;
	private OrthographicCamera cam;
	private TiledMap tiledMap;
	private Viewport viewport;
	private OrthogonalTiledMapRenderer renderer;
	private Music music;
	
	public MainCity(Wave game) {
		this.game = game;
		cam = new OrthographicCamera();
		tiledMap = new TmxMapLoader().load("map/PortalArea1/portal_area_1.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap, 0.8f);
		viewport = new FitViewport(800, 480, cam);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		music = Gdx.audio.newMusic(Gdx.files.internal("Music/cancer.ogg"));
		music.setVolume(0.1f);
		music.play();
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
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.setProjectionMatrix(cam.combined);
		renderer.setView(cam);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		
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
