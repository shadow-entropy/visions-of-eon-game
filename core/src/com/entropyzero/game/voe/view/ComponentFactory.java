package com.entropyzero.game.voe.view;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.entropyzero.game.voe.asset.Font;
import com.entropyzero.game.voe.screen.ScreenSize;
import com.entropyzero.game.voe.util.Palette;

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
        pane.setVisible(false);
        return pane;
    }

    static Button newSkillPaneButton(ScrollPane skillPane) {
        var skin = SKILL_PANE.skin();
        var buttonStyle = new Button.ButtonStyle(
                skin.getDrawable("skill-pane-button"),
                skin.getDrawable("skill-pane-button-focus"),
                skin.getDrawable("skill-pane-button-focus")
        );
        var button = new Button(buttonStyle);

        var font = Font.AMAZ_OBITAEM.generateWithMipMaps(p -> p.size = 60);
        var labelStyleDark = new Label.LabelStyle(font, Palette.SPACE_TWILIGHT);
        var labelStyleLight = new Label.LabelStyle(font, Palette.QUARTZ);
        var label = new Label("Навыки", labelStyleDark);
        var wrapper = Wrapper.of(label);
        wrapper.setRotation(-58);
        wrapper.setPosition(110, 185);

        button.setTransform(true);
        button.setPosition(10 , 20);
        button.setScale(0.6f);
        button.addActor(wrapper);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean visible = skillPane.isVisible();
                skillPane.setVisible(!visible);
                label.setStyle(visible ? labelStyleDark : labelStyleLight);
            }
        });
        return button;
    }

    static ScrollPane newAttackChainPane() {
        var group = new HorizontalGroup();
        var pane = new ScrollPane(group, (Skin) null);
        return pane;
    }


}
