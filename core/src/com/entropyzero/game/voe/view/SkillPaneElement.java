package com.entropyzero.game.voe.view;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.entropyzero.game.voe.screen.ScreenSize;
import com.entropyzero.game.voe.util.Palette;

import static com.entropyzero.game.voe.asset.Component.SKILL_ICON;
import static com.entropyzero.game.voe.asset.Component.SKILL_PANE;

public class SkillPaneElement extends Group {

    private static final float EXTRA_SCALE = 0.3f;

    private float scale;

    private Label title;
    private Label text;
    private Image skillIcon;
    private Image background;
    private ImageButton chainingButton;

    public SkillPaneElement(ScreenSize screenSize) {
        this.scale = screenSize.scaleFrom(ScreenSize.HD);
    }

    public SkillPaneElement title(String content, BitmapFont font) {
        title = new Label(content, new Label.LabelStyle(font, Palette.SPRING_SKY));
        title.setZIndex(5);
        return this;
    }

    /**
     * @param content no longer than 14 symbols
     */
    public SkillPaneElement description(String content, BitmapFont font) {
        text = new Label(content, new Label.LabelStyle(font, Palette.QUARTZ));
        text.setPosition(50 * scale, 50 * scale);
        text.setSize(200 * scale, 80 * scale);
        text.setAlignment(Align.center, Align.center);
        text.setZIndex(6);
        return this;
    }

    public SkillPaneElement icon(String style) {
        skillIcon = new Image(SKILL_ICON.skin().getDrawable(style));
        skillIcon.setScale(scale * 0.27f);
        skillIcon.setPosition(75, 210);
        skillIcon.setZIndex(10);
        return this;
    }

    public SkillPaneElement background() {
        return background("skill-pane-element");
    }


    public SkillPaneElement background(String style) {
        background = new Image(SKILL_PANE.skin().getDrawable(style));
        background.setScale(scale * EXTRA_SCALE);
        background.setZIndex(1);
        return this;
    }

    public SkillPaneElement chainingButton(ClickListener clickListener) {
        chainingButton = new ImageButton(SKILL_PANE.skin(), "chain-button-style");
        chainingButton.setPosition(252 * scale, 64 * scale);
        chainingButton.setSize(184.5f * scale * EXTRA_SCALE,274.5f * scale * EXTRA_SCALE);
        chainingButton.setZIndex(7);
        if(clickListener != null) {
            chainingButton.addListener(clickListener);
        }
        return this;
    }

    public SkillPaneElement setup() {
        addActor(background);
        addActor(skillIcon);
        addActor(chainingButton);

        var titleWrapper = Wrapper.of(title);
        titleWrapper.setPosition(225 * scale, 155 * scale);
        titleWrapper.setRotation(10);

        addActor(titleWrapper);
        addActor(text);

        setSize(400 * scale, 180 * scale);
        return this;
    }
}
