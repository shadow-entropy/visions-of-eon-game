package com.entropyzero.game.voe.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.entropyzero.game.voe.VisionsOfEonGame;
import com.entropyzero.game.voe.component.Components;

public class BattleScreen extends ScreenAdapter {

    private VisionsOfEonGame game;
    private Stage stage;
    private Viewport viewport;

    public BattleScreen(VisionsOfEonGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        viewport = new FillViewport(1280, 720);
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);

        stage.addActor(Components.newSkillPane());
    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(.1f, .1f, .2f, 1);
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
