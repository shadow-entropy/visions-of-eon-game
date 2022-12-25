package com.entropyzero.game.voe.component;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.entropyzero.game.voe.asset.Assets;

public class SkillPaneElement extends Group {

    private Label title;
    private Label text;
    private Image background;
    private Image skillIcon;
    private ImageButton chainingButton;

    public SkillPaneElement(Builder builder) {
        var skin = Assets.TILTED_SCROLL_PANE.skin();

        title = new Label(builder.titleContent, skin, "skill-name");
        title.setPosition(40, 160);
        title.setZIndex(5);

        text = new Label(builder.textContent, skin, "skill-description");
        text.setPosition(40, 120);
        text.setZIndex(6);

        background = new Image(skin.getDrawable("skill-pane-element"));
        background.setZIndex(4);

        setSize(400, 180);
        addActor(background);
        addActor(Wrapper.of(title).rotation(150));
        addActor(text);
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
