package com.entropyzero.game.voe.screen;

public enum ScreenSize {

    HD(1280, 720),
    HD_2K(1920, 1080);

    private final int width;
    private final int height;

    ScreenSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public float scaleFrom(ScreenSize other) {
        return (this == other) ? 1f : (float) this.width / other.width;
    }
}
