package com.entropyzero.game.voe.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.entropyzero.game.voe.asset.Component;
import com.entropyzero.game.voe.asset.Font;
import com.entropyzero.game.voe.screen.ScreenSize;
import com.entropyzero.game.voe.util.Palette;

public class SkillPaneElement extends Group {

    private Label title;
    private Label text;
    private Image background;
    private Image skillIcon;
    private ImageButton chainingButton;

    /**
     * @param skillName no longer than 14 symbols
     * @param description
     */
    public SkillPaneElement(ScreenSize screenSize, String skillName, String description) {
        this(screenSize, skillName, description, "skill-pane-element");
    }

    public SkillPaneElement(ScreenSize screenSize, String skillName, String description, String style) {
        var skin = Component.SKILL_PANE.skin();
        float scale = 0.3f;
        float s = screenSize.scaleFrom(ScreenSize.HD);

        var titleFont = Font.AMAZ_OBITAEM.generateWithMipMaps(p -> p.size = (int) (20 * s));
        title = new Label(skillName, new Label.LabelStyle(titleFont, Palette.SPRING_SKY));
        title.setZIndex(5);

        var textFont = Font.BLOB_SPONGEY.generateWithMipMaps(p -> p.size = (int) (16 * s));
        text = new Label(description, new Label.LabelStyle(textFont, Palette.QUARTZ));
        text.setPosition(50 * s, 50 * s);
        text.setZIndex(6);
        text.setSize(200 * s, 80 * s);
        text.setAlignment(Align.center, Align.center);

        background = new Image(skin.getDrawable(style));
        background.setScale(scale * s);
        background.setZIndex(1);

        chainingButton = new ImageButton(skin, "chain-button-style");
        chainingButton.setPosition(252 * s, 64 * s);
        chainingButton.setSize(184.5f * scale * s,274.5f * scale * s);
        chainingButton.setZIndex(7);
        chainingButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Click", text.toString());
            }
        });

        addActor(background);
        addActor(chainingButton);

        var titleWrapper = Wrapper.of(title);
        titleWrapper.setPosition(225 * s, 155 * s);
        titleWrapper.setRotation(10);

        addActor(titleWrapper);
        addActor(text);

        setSize(400 * s, 180 * s);
    }
}
