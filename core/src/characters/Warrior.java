package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Warrior extends Player{
	private String name;
	private String classType;
	private int level;
	private Texture texture ;
	
	public Warrior (String name, String classType, int level) {
		super(name, classType, level, new Texture(Gdx.files.internal("art/character.png"))); 
	}
	
	public void dash() {
		
	}
	
	public void smash() {
		
	}
	
	public void powerUp() {
		
	}
	
	public void pull() {
		
	}
	
	public void stab() {
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
