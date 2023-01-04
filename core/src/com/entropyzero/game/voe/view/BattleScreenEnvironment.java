package com.entropyzero.game.voe.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class BattleScreenEnvironment implements ScreenEnvironment {


    private ScrollPane skillPane;
    private Button skillPaneButton;
    private ScrollPane attackChainPane;


    public BattleScreenEnvironment() {
        this.skillPane = ComponentFactory.newSkillPane();
        this.skillPaneButton = ComponentFactory.newSkillPaneButton(skillPane);
        //this.attackChainPane = ComponentFactory.newAttackChainPane();
    }

    @Override
    public void addActorsOn(Stage stage) {
        stage.addActor(skillPane);
        stage.addActor(skillPaneButton);
        //stage.addActor(attackChainPane);
    }
}
