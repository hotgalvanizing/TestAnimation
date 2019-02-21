package com.mx.testanimation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mx.testanimation.R;

public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        ImageView anim = findViewById(R.id.anim);

        anim.setBackground(getResources().getDrawable(R.drawable.fat_po));
        final AnimationDrawable animationDrawable = (AnimationDrawable) anim.getBackground();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });
    }
}
