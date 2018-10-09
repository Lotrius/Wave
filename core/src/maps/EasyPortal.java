package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import characters.Player;
import characters.Warrior;
import wave.Wave;

public class EasyPortal extends InGameScreen {
	private Wave game;


	public EasyPortal(Wave game, Player player) {
		// Set up parameters
		this.game = game;
		this.player = player;

		// Create new tiled map and get dimensions
		tiledMap = new TmxMapLoader().load("map/EasyPortal/easy_portal.tmx");
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
	}

	protected void checkCollision() {
		// Call checkCollision() in super class
		//super.checkCollision(collisionObjects);
	}

	public void changeMap() {
		// If the player tries to take the road to the portal area, dispose of current screen
		// and load portal area
		if (Gdx.input.isKeyPressed(Keys.K)) { 
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
		
		game.batch.end();

	}

	@Override
	public void dispose() {
		// Destroy everything
		// music.dispose();
		// grass.dispose()
	}

}
