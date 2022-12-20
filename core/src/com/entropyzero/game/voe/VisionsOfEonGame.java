package com.entropyzero.game.voe;

import com.badlogic.gdx.Game;
import com.entropyzero.game.voe.screen.MainMenuScreen;

public class VisionsOfEonGame extends Game {

	MainMenuScreen mainMenuScreen;
	
	@Override
	public void create () {
		mainMenuScreen = new MainMenuScreen(this);
		setScreen(mainMenuScreen);
		//img = new Texture("badlogic.jpg");
	}
}
