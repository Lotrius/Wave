package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;

import characters.Player;
import characters.Warrior;
import wave.Wave;

public class PortalArea1 extends InGameScreen {
	private Wave game;
	private Music music;
	private Sound grass;
	BitmapFont font;

	protected MapObjects collisionObjects;

	public PortalArea1(Wave game, Player player) {

		font = new BitmapFont();
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
		x = 1550;
		y = 800;

		cam.position.x = 1325;
		cam.position.y = y;

		collisionObjects = tiledMap.getLayers().get("Collision-2").getObjects();
		System.out.println(collisionObjects.getCount());

		grass = Gdx.audio.newSound(Gdx.files.internal("sounds/grass.ogg"));

		// music = Gdx.audio.newMusic(Gdx.files.internal("Music/cancer.ogg"));
		// music.setVolume(0.1f);
		// music.play();
	}

	public void checkCollision() {
		for (RectangleMapObject rectangleObject : collisionObjects
				.getByType(RectangleMapObject.class)) {
			Rectangle rectangle = rectangleObject.getRectangle();
			if (Intersector.overlaps(rectangle, player.getBody())) {
				System.out.println("HI");
			}
		}
	}

	public void changeMap() {
		if (player.getX() >= 1580 && player.getY() > 760 && player.getY() < 830
				&& Gdx.input.isKeyPressed(Keys.RIGHT)) {
			this.dispose();
			game.setScreen(new MainCity(game, player));
		}
	}

	@Override
	public void render(float delta) {
		// Exit if ESC pressed
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}

		if (Gdx.input.isKeyPressed(Keys.K)) {
			grass.play(1.0f);
		}

		// Set up camera and view
		game.batch.setProjectionMatrix(cam.combined);
		renderer.setView(cam);
		renderer.render();

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
				player.getX() - 10, player.getY() - 10);
		font.draw(game.batch, String.format("%.0f", player.getY()),
				player.getX() + 20, player.getY() - 10);
		game.batch.end();

	}

	@Override
	public void dispose() {
		// Destroy music
		// music.dispose();
	}

}
