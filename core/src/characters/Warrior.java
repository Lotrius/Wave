package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Warrior extends Player{
	private String name;
	private String classType;
	private int level;
	private Texture texture ;
	
	public Warrior (String name, String classType, int level) {
		super(name, classType, level, new Texture(Gdx.files.internal("art/player.png"))); 
	}
}
