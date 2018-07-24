package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

public abstract class Player {
	public static int SPEED = 400;
	private String name;
	private String classType;
	private int level;
	private Texture texture;

	public Player(String name, String classType, int level, Texture texture) {
		this.name = name; 
		this.classType = classType;
		this.level = level;
		this.texture = texture;
		final int PLAYER_WIDTH = 20;
		final int PLAYER_HEIGHT = 20;
	}

	public Texture getTexture() {
		return this.texture;
	}

}
