package com.entropyzero.game.voe.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.entropyzero.game.voe.VisionsOfEonGame;
import com.entropyzero.game.voe.screen.ScreenSize;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Visions Of Eon: Space Adventure";
		ScreenSize size = ScreenSize.HD_2K;
		config.height = size.height();
		config.width = size.width();
		new LwjglApplication(new VisionsOfEonGame(), config);
	}
}
