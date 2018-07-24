package com.mygdx.wave.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import wave.Wave;

public class DesktopLauncher {
	public static void main(String[] args) {
		// SETUP
		LwjglApplicationConfiguration config =
				new LwjglApplicationConfiguration();
		config.title = "Wave";
		config.width = Wave.V_WIDTH;
		config.height = Wave.V_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new Wave(), config);
	}
}
