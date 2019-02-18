package com.mx.testanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4, button5;

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

        button4 = findViewById(R.id.activity4);
        button4.setOnClickListener(this);

        button5 = findViewById(R.id.activity5);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.activity1:
                intent = new Intent(this, FrameActivity.class);
                startActivity(intent);
                break;

            case R.id.activity2:
                intent = new Intent(this, BlastActivity.class);
                startActivity(intent);
                break;

            case R.id.activity3:
                intent = new Intent(this, TweenActivity.class);
                startActivity(intent);
                break;

            case R.id.activity4:
                intent = new Intent(this, BufferFlyActivity.class);
                startActivity(intent);
                break;

            case R.id.activity5:
                intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
