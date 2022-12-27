package com.entropyzero.game.voe.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.entropyzero.game.voe.asset.Component;
import com.entropyzero.game.voe.asset.Font;
import com.entropyzero.game.voe.util.Palette;

public class SkillPaneElement extends Group {

    private Label title;
    private Label text;
    private Image background;
    private Image skillIcon;
    private ImageButton chainingButton;

    public SkillPaneElement(Builder builder) {
        var skin = Component.SKILL_PANE.skin();
        float scale = 0.3f;

        var am32 = Font.AMAZ_OBITAEM.newBitmapFont().withMipMaps().build(p ->  {
            p.size = 32;
            p.characters = "Текст12"; //ToDo add all chars
        });
        //var am20 = Font.AMAZ_OBITAEM.newBitmapFont().withMipMaps().build(p -> p.size = 20);

        //ToDo https://libgdx.com/wiki/extensions/gdx-freetype
        title = new Label(builder.titleContent, new Label.LabelStyle(am32, Palette.LILAC));
        title.setPosition(40, 160);
        title.setZIndex(5);

        text = new Label(builder.textContent, new Label.LabelStyle(am32, Palette.SPRING_SKY));
        text.setPosition(40, 120);
        text.setZIndex(6);

        background = new Image(skin.getDrawable("skill-pane-element"));
        background.setScale(scale);
        background.setZIndex(4);

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

        setSize(400, 180);
        addActor(background);
        addActor(Wrapper.of(title).rotation(150));
        addActor(text);
        addActor(chainingButton);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        String titleContent, textContent;

        public Builder title(String content) {
            titleContent = content;
            return this;
        }

        public Builder text(String content) {
            textContent = content;
            return this;
        }

        public SkillPaneElement build() {
            return new SkillPaneElement(this);
        }
    }
}
