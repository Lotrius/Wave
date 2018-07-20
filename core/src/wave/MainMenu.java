package wave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import maps.MainCity;

public class MainMenu implements Screen {
	private Wave game;
	private Music music;
	private Texture texture;

	public MainMenu(Wave game) {
		this.game = game;
		texture = new Texture("art/wave.jpg");
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
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.dispose();
			game.setScreen(new MainCity(game));
		}
		game.batch.begin();
		game.batch.draw(texture, 0, 0);
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
