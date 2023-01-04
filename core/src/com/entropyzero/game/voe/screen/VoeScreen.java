package com.entropyzero.game.voe.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.entropyzero.game.voe.VisionsOfEonGame;
import com.entropyzero.game.voe.view.BattleScreenEnvironment;
import com.entropyzero.game.voe.view.ScreenEnvironment;

public class VoeScreen extends ScreenAdapter {

    protected VisionsOfEonGame game;
    protected ScreenEnvironment environment;
    protected Viewport viewport;
    protected Stage stage;

    public VoeScreen(VisionsOfEonGame game, ScreenEnvironment environment) {
        this.game = game;
        this.environment = environment;
    }

    @Override
    public void show() {
        ScreenSize size = ScreenSize.HD_2K;
        viewport = new ExtendViewport(size.width(), size.height());
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);
        environment.addActorsOn(stage);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
