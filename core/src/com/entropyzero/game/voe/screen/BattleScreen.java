package com.entropyzero.game.voe.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.entropyzero.game.voe.VisionsOfEonGame;
import com.entropyzero.game.voe.view.ScreenEnvironment;

public class BattleScreen extends VoeScreen {

    public BattleScreen(VisionsOfEonGame game, ScreenEnvironment environment) {
        super(game, environment);
    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(.1f, .1f, .2f, 1);
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
