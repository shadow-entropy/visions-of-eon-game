package com.entropyzero.game.voe.asset;

public interface AssetEnum {

    String name();

    default String assetName() {
        return name().toLowerCase().replaceAll("_", "-");
    }
}
