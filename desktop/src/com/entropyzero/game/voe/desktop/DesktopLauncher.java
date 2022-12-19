package com.entropyzero.game.voe.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.entropyzero.game.voe.VisionsOfEonGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Vision Of Eon: Space Adventure";
		config.height = 720;
		config.width = 1280;
		new LwjglApplication(new VisionsOfEonGame(), config);
	}
}
