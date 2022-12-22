package com.entropyzero.game.voe.component;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.entropyzero.game.voe.asset.Assets;

public interface Components {

    static ScrollPane newSkillPane() {
        var skin = Assets.TILTED_SCROLL_PANE.skin();

        VerticalGroup group = new VerticalGroup().space(30);
        group.addActor(SkillPaneElement.builder().title("001").text("Текст").build());
        group.addActor(SkillPaneElement.builder().title("002").text("Текст").build());
        group.addActor(SkillPaneElement.builder().title("003").text("Текст").build());

        var pane = new ScrollPane(group, skin);

        pane.setPosition(100, 100);
        pane.setSize(500, 500);
        return pane;
    }
}
