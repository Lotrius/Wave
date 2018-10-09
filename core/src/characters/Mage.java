package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Mage extends Player{
	private String name;
	private String classType;
	private int level;
	private Texture texture ;
	
	public Mage(String name, String classType, int level) {
		super(name, classType, level, new Texture(Gdx.files.internal("art/character.png"))); 
	}
	
	public void teleport() {
		
	}
	
	public void firebolt() {
		
	}
	
	public void powerUp() {
		
	}
	
	public void earthquake() {
		
	}
	
	public void shield() {
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
