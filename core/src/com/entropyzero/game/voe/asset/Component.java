package com.entropyzero.game.voe.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public enum Component implements AssetEnum {

    SKILL_PANE
    ;

    Component() {
        String assetName = assetName();
        String atlasPath = "texture/%s.atlas".formatted(assetName);
        String stylePath = "style/%s.json".formatted(assetName);
        this.atlas = new TextureAtlas(Gdx.files.internal(atlasPath));
        this.skin = new Skin(Gdx.files.internal(stylePath), atlas);
    }

    private final TextureAtlas atlas;
    private final Skin skin;


    public Skin skin() {
        return skin;
    }
}
