package com.example.kempo.multitasking;

import android.graphics.RectF;

/**
 * Created by kempo on 4/6/18.
 */

public class ReactionButton {

    private RectF mRect;
    private float mButtonWidth;
    private float mButtonHeight;
    private float mXCoord;
    private float mYCoord;
    public ReactionButton(int screenX, int screenY){

        // Make the mBall size relative to the screen resolution
        mButtonWidth = screenX / 6;
        mButtonHeight = mButtonWidth;


        new RectF();
        mRect = new RectF();
    }
    public RectF getRect(){
        return mRect;
    }

    public void set(int x, int y){
        mRect.left = x - mButtonWidth / 2;
        mRect.top = y + mButtonHeight/2;
        mRect.right = x + mButtonWidth/2;
        mRect.bottom = y - mButtonHeight/2;
    }
}
