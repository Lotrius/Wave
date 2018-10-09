package characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import wave.Wave;

public abstract class Player {
	public static int SPEED = 400;
	private String name;
	private String classType;
	private int level;
	private Texture texture;
	private Rectangle body;
	private float x,y;

	public Player(String name, String classType, int level, Texture texture) {
		x = Wave.V_WIDTH;
		y = Wave.V_HEIGHT;
		this.name = name; 
		this.classType = classType;
		this.level = level;
		this.texture = texture;
		final int PLAYER_WIDTH = 20;
		final int PLAYER_HEIGHT = 20;
		body = new Rectangle(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	public Rectangle getBody() {
		return this.body;
	}

	public Texture getTexture() {
		return this.texture;
	}
	 
	public float getX() {
		return x;
	} 
	
	public float getY() {
		return y;
	} 
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public abstract void attack();

}
