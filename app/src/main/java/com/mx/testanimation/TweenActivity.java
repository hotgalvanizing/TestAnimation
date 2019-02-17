package com.mx.testanimation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        final ImageView flower = findViewById(R.id.flower);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        animation.setFillAfter(true);

        final Animation reverse = AnimationUtils.loadAnimation(this, R.anim.reverse);
        reverse.setFillAfter(true);

        Button btn = findViewById(R.id.bn);

        final Handler handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    flower.startAnimation(reverse);
                }
            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flower.startAnimation(animation);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                }, 3500);
            }
        });


    }
}
