package com.entropyzero.game.voe.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public enum Assets {

    METALLIC_BUTTON("style/button.json", "texture/metallic_button.atlas")
    ;

    Assets(String path, String textureAtlasPath) {
        this.skinPath = path;
        this.textureAtlasPath = textureAtlasPath;
    }

    private final String skinPath;
    private final String textureAtlasPath;

    public Skin asSkin() {
        return new Skin(Gdx.files.internal(skinPath), asTextureAtlas());
    }

    public TextureAtlas asTextureAtlas() {
        return new TextureAtlas(Gdx.files.internal(textureAtlasPath));
    }
}
