package com.entropyzero.game.voe.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.function.Consumer;

public enum Font implements AssetEnum {

    AMAZ_OBITAEM;

    Font() {
        fontPath = "font/%s.fnt".formatted(assetName());
    }

    private final String fontPath;

    public FontBuilder newBitmapFont() {
        return new FontBuilder();
    }

    public static class FontBuilder {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        public FontBuilder withMipMaps() {
            parameter.genMipMaps = true;
            parameter.minFilter = Texture.TextureFilter.MipMapLinearLinear;
            parameter.magFilter = Texture.TextureFilter.Linear;
            return this;
        }

        public BitmapFont build(Consumer<FreeTypeFontGenerator.FreeTypeFontParameter> config) {
            //ToDo use ttf font path
            var generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Amazobitaemostrovitalic-A4P7.ttf"));
            config.accept(parameter);
            var font = generator.generateFont(parameter);
            generator.dispose();
            return font;
        }

    }
}
