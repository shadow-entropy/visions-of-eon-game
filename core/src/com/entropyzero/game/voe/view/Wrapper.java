package com.entropyzero.game.voe.view;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class Wrapper<A extends Actor> extends Table {


    //https://gamedev.stackexchange.com/questions/152168/rotate-a-single-member-of-a-group
    private Wrapper(A actor) {
        super();
        actor.setOrigin(Align.center);
        setTransform(true);
        setFillParent(false);
        add(actor);
    }

    public static <A extends Actor> Wrapper<A> of(A actor) {
        return new Wrapper<>(actor);
    }
}
