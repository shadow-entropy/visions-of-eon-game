package com.entropyzero.game.voe.presenter;

public abstract class AbstractPresenter<M, V> {

    M model;
    V view;

    public M getModel() {
        return model;
    }

    public V getView() {
        return view;
    }

    public void init() {

    }
}
