package com.entropyzero.game.voe;

import com.badlogic.gdx.Game;
import com.entropyzero.game.voe.screen.BattleScreen;
import com.entropyzero.game.voe.view.BattleScreenEnvironment;

public class VisionsOfEonGame extends Game {

	BattleScreen battleScreen;
	
	@Override
	public void create () {
		battleScreen = new BattleScreen(this, new BattleScreenEnvironment());
		setScreen(battleScreen);
	}
}
