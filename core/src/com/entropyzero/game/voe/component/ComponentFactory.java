package com.entropyzero.game.voe.component;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.entropyzero.game.voe.asset.Component;

public interface ComponentFactory {

    static ScrollPane newSkillPane() {
        var skin = Component.SKILL_PANE.skin();

        VerticalGroup group = new VerticalGroup().space(5).padTop(150);
        float angle = 5f;
        group.setRotation(angle);
        group.addActor(new SkillPaneElement("Мега атака", "a\na")
        );
        group.addActor(new SkillPaneElement("Мега атака", "a")
        );
        group.addActor(new SkillPaneElement("Огненная жатва",
                        """
                        Призывает огненный шторм.
                        Длится 3 хода
                        """)
        );
        group.addActor(new SkillPaneElement(
                "Суперпозиция",
                "Последная атака\nповторяется 8-12 раз",
                "skill-pane-last-element"
                )
        );

        var pane = new ScrollPane(group, skin);

        pane.setPosition(0, -100);
        pane.setSize(650, 800);
        pane.setRotation(angle);
        return pane;
    }
}
