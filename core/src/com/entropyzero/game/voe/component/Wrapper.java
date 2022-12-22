package com.entropyzero.game.voe.component;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class Wrapper<A extends Actor> extends Table {


    //https://gamedev.stackexchange.com/questions/152168/rotate-a-single-member-of-a-group
    private Wrapper(A actor) {
        super();
        setTransform(true);
        setFillParent(false);
        add(actor);
    }

    public static <A extends Actor> Wrapper<A> of(A actor) {
        return new Wrapper<>(actor);
    }

    public Wrapper<A> rotation(float angle) {
        setRotation(angle);
        return this;
    }
}