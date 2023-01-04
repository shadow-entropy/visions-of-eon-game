package com.entropyzero.game.voe.view;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.entropyzero.game.voe.asset.Font;
import com.entropyzero.game.voe.screen.ScreenSize;

import static com.entropyzero.game.voe.asset.Component.SKILL_PANE;

public interface ComponentFactory {

    static ScrollPane newSkillPane() {
        var screenSize = ScreenSize.HD_2K;
        float scale = screenSize.scaleFrom(ScreenSize.HD);
        var titleFont = Font.AMAZ_OBITAEM.generateWithMipMaps(p -> p.size = (int) (20 * scale));
        var descFont = Font.BLOB_SPONGEY.generateWithMipMaps(p -> p.size = (int) (16 * scale));

        SkillPaneElement e1 = new SkillPaneElement(screenSize)
                        .title("Мега защита", titleFont)
                        .description("a\na", descFont)
                        .icon("defence-skill-icon")
                        .background()
                        .chainingButton(null)
                        .setup(),
                e2 = new SkillPaneElement(screenSize)
                        .title("Мега бафф", titleFont)
                        .description("a", descFont)
                        .icon("effect-skill-icon")
                        .background()
                        .chainingButton(null)
                        .setup(),
                e3 = new SkillPaneElement(screenSize)
                        .title("Огненная жатва", titleFont)
                        .description("""
                        За [#7471FF]15 SP[] призывает огненный шторм.
                        Длится 3 хода
                        """, descFont)
                        .icon("elemental-skill-icon")
                        .background()
                        .chainingButton(null)
                        .setup(),
                e4 = new SkillPaneElement(screenSize)
                        .title("Суперпозиция", titleFont)
                        .description("Последная атака\nповторяется 8-12 раз", descFont)
                        .icon("position-skill-icon")
                        .background("skill-pane-last-element")
                        .chainingButton(null)
                        .setup();

        VerticalGroup group = new VerticalGroup().space(5).padTop(150);
        float angle = 5f;
        group.setRotation(angle);
        group.addActor(e1);
        group.addActor(e2);
        group.addActor(e3);
        group.addActor(e4);

        var pane = new ScrollPane(group, SKILL_PANE.skin());
        pane.setPosition(0, -100 * scale);
        pane.setSize(650 * scale, 800 * scale);
        pane.setRotation(angle);
        return pane;
    }
}
