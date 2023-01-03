package com.entropyzero.game.voe.component;

import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.entropyzero.game.voe.asset.Component;
import com.entropyzero.game.voe.screen.ScreenSize;

public interface ComponentFactory {

    static ScrollPane newSkillPane() {
        var skin = Component.SKILL_PANE.skin();
        var screenSize = ScreenSize.HD_2K;
        float scale = screenSize.scaleFrom(ScreenSize.HD);

        VerticalGroup group = new VerticalGroup().space(5).padTop(150);
        float angle = 5f;
        group.setRotation(angle);
        group.addActor(new SkillPaneElement(screenSize, "Мега атака", "a\na")
        );
        group.addActor(new SkillPaneElement(screenSize,"Мега атака", "a")
        );
        group.addActor(new SkillPaneElement(screenSize,"Огненная жатва",
                        """
                        За [#7471FF]15 SP[] призывает огненный шторм.
                        Длится 3 хода
                        """)
        );
        group.addActor(new SkillPaneElement(screenSize,
                "Суперпозиция",
                "Последная атака\nповторяется 8-12 раз",
                "skill-pane-last-element"
                )
        );

        var pane = new ScrollPane(group, skin);

        pane.setPosition(0, -100 * scale);
        pane.setSize(650 * scale, 800 * scale);
        pane.setRotation(angle);
        return pane;
    }
}
