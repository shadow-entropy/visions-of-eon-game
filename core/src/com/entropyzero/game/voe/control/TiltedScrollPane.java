package com.entropyzero.game.voe.control;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.LinkedList;

public class TiltedScrollPane extends ScrollPane {


    //private W[] elements;
    //private int currentIndex;
    private Button topArrow;
    private Button bottomArrow;
    private boolean hideArrows;

    private int firstVisiblePosition;
    private int visualCapacity;
    private float paneIncline;
    private float elementIncline;

    private float elementSizeRegression;

    public TiltedScrollPane(Actor widget, Skin skin) {
        super(widget, skin);
    }


    //private T[] elements;

    private void resize() {
        int lastVisiblePosition = firstVisiblePosition + visualCapacity;
        float scale = 1f;
        for(int i = 0; i < getChildren().size; i++) {
            var child = getChild(i);
            if(i < firstVisiblePosition || i > lastVisiblePosition) {
                child.setVisible(true);
                child.setScale(scale);
                scale *= elementSizeRegression;
            }
            else {
                child.setVisible(false);
            }
        }
    }
}
