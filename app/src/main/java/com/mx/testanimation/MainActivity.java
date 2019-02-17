package com.mx.testanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.activity1);
        button1.setOnClickListener(this);

        button2 = findViewById(R.id.activity2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.activity3);
        button3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.activity1:
                intent = new Intent(this, FrameActivity.class);
                startActivity(intent);
                return;

            case R.id.activity2:
                intent = new Intent(this, BlastActivity.class);
                startActivity(intent);
                return;

            case R.id.activity3:
                intent = new Intent(this, TweenActivity.class);
                startActivity(intent);
                return;

            default:
                break;
        }
    }
}