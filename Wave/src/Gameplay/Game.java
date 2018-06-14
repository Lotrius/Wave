/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Solomon
 */
public class Game {
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new GameSetUp("Wave"));
        app.setDisplayMode(1920, 1080, true);
        app.start();
    }
}
