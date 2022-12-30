package com.entropyzero.game.voe.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.function.Consumer;

public enum Font implements AssetEnum {

    AMAZ_OBITAEM,
    EXO_2_LIGHT_ITALIC,
    GALIVER_SANS,
    GPUTEKS_REGULAR,
    GPUTEKS_BOLD,
    KAPPAS_POROROCA,
    LINERAMA_BOLD,
    BICUBIK("font/bicubik.otf");


    public static final String CHARACTERS = """
        ABCDEFGHIJKLMNOPGRSTUVWXYZ
        abcdefghijklmnopgrstuvwxyz
        АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ
        абвгдеёжзийклмнопрстуфхцчшщъыьэюя
        0123456789 -+=\\/.,:;()*%!?
        """;
    private final String fontPath;

    Font() {
        fontPath = "font/%s.ttf".formatted(assetName());
    }

    Font(String fontPath) {
        this.fontPath = fontPath;
    }

    public BitmapFont generateWithMipMaps(Consumer<FreeTypeFontGenerator.FreeTypeFontParameter> config) {
        var parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = CHARACTERS;
        parameter.genMipMaps = true;
        parameter.minFilter = Texture.TextureFilter.MipMapLinearLinear;
        parameter.magFilter = Texture.TextureFilter.Linear;
        config.accept(parameter);

        var generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));

        var font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }
}
