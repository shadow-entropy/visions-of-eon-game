package com.entropyzero.game.voe.component;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.entropyzero.game.voe.asset.Component;

public interface ComponentFactory {

    static ScrollPane newSkillPane() {
        var skin = Component.SKILL_PANE.skin();

        VerticalGroup group = new VerticalGroup().space(5);
        float angle = 5f;
        group.setRotation(angle);
        group.addActor(SkillPaneElement.builder().title("001").text("Текст").build());
        group.addActor(SkillPaneElement.builder().title("002").text("Текст2").build());
        group.addActor(SkillPaneElement.builder().title("003").text("Текст3").build());
        group.addActor(SkillPaneElement.builder().title("003").text("Текст4").build());

        var pane = new ScrollPane(group, skin);

        pane.setPosition(0, 0);
        pane.setSize(700, 700);
        pane.setRotation(angle);
        return pane;
    }
}
