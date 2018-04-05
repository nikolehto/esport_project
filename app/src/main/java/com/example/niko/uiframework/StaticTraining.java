package com.example.niko.uiframework;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaticTraining extends AppCompatActivity {

    Button targetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_before_screen);
    }

    protected void reset(){

    }

    public void launchTraining(View view)
    {
        reset();
        setContentView(R.layout.activity_static_training);
        targetButton = findViewById(R.id.static_target);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                targetButton.setVisibility(View.VISIBLE);
            }
        }, 1300);
    }

    public void userReacted(View view)
    {
        //setContentView(R.layout.activity_static_training);
    }

    public void showResult(View view)
    {
        setContentView(R.layout.activity_static_result_screen0);
    }

    public void restart(View view)
    {
        reset();
        setContentView(R.layout.activity_static_training);
        targetButton = findViewById(R.id.static_target);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                targetButton.setVisibility(View.VISIBLE);
            }
        }, 1300);
    }

    public void returnMenu(View view)
    {
        finish();
    }

}
