package com.entropyzero.game.voe.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.entropyzero.game.voe.VisionsOfEonGame;
import com.entropyzero.game.voe.asset.Assets;
import com.entropyzero.game.voe.control.TiltedScrollPane;

public class MainMenuScreen extends ScreenAdapter {

    private VisionsOfEonGame game;
    private Stage stage;
    private Viewport viewport;

    public MainMenuScreen(VisionsOfEonGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        viewport = new ExtendViewport(1280, 720);
        stage = new Stage(viewport);


/*        var skin = Assets.METALLIC_BUTTON.skin();
        var button = new TextButton("Играть", skin, "default");
        button.setPosition(100, 100);
        stage.addActor(button);*/
        //ToDo
        List<Label> content = new List<>(null,null);
        content.setItems(
                new Label("001", (Skin) null),
                new Label("", (Skin) null)
        );
        var pane = new TiltedScrollPane(content, Assets.TILTED_SCROLL_PANE.skin());

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .1f, .2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
