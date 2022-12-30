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
    public SkillPaneElement(String skillName, String description) {
        this(skillName, description, "skill-pane-element");
    }

    public SkillPaneElement(String skillName, String description, String style) {
        var skin = Component.SKILL_PANE.skin();
        float scale = 0.3f;

        var titleFont = Font.AMAZ_OBITAEM.generateWithMipMaps(p -> p.size = 20);
        title = new Label(skillName, new Label.LabelStyle(titleFont, Palette.SPRING_SKY));
        title.setZIndex(5);

        var textFont = Font.LINERAMA_BOLD.generateWithMipMaps(p -> p.size = 16);
        text = new Label(description, new Label.LabelStyle(textFont, Palette.QUARTZ));
        text.setPosition(50, 50);
        text.setZIndex(6);
        text.setSize(200, 80);
        text.setAlignment(Align.center, Align.center);

        background = new Image(skin.getDrawable(style));
        background.setScale(scale);
        background.setZIndex(1);

        chainingButton = new ImageButton(skin, "chain-button-style");
        chainingButton.setPosition(252, 64);
        chainingButton.setSize(184.5f * scale,274.5f * scale);
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
        titleWrapper.setPosition(225, 155);
        titleWrapper.setRotation(10);

        addActor(titleWrapper);
        addActor(text);

        setSize(400, 180);
    }
}
