package com.mx.testanimation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.mx.testanimation.R;

import java.util.Timer;
import java.util.TimerTask;

public class BufferFlyActivity extends AppCompatActivity {

    private float curX = 0;
    private float curY = 30;

    private float nextX = 0;
    private float nextY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer_fly);

        final ImageView imageView = findViewById(R.id.butterfly);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    if (nextX > 320) {
                        curX = nextX = 0;
                    } else {
                        nextX += 8;
                    }
                }
                nextY = (float) (curY + (Math.random() * 10 - 5));
                TranslateAnimation anim = new TranslateAnimation(curX, nextX, curY, nextY);
                curX = nextX;
                curY = nextY;
                anim.setDuration(200);
                imageView.startAnimation(anim);
            }
        };

        final AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                },0,200);
            }
        });
    }
}
