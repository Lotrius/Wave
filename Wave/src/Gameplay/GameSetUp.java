/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author Chris
 */
public class GameSetUp extends BasicGame{
    private Music music;
    private Sound sound;
    public GameSetUp(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        music = new Music("Music/song.ogg");
        music.setVolume(1.0f);
        music.loop();
        //sound = new Sound();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {

    }
    
}
