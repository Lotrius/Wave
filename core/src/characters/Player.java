package characters;

import com.badlogic.gdx.graphics.Texture;

public abstract class Player {
	public static final int SPEED = 400;
	private String name;
	private String classType;
	private int level;
	private Texture texture;
	
	
	public Player (String name, String classType, int level, Texture texture) {
		this.name = name;
		this.classType = classType;
		this.level = level;
		this.texture = texture;
	}
	
	public Texture getTexture() {
		return this.texture;
	}
}
