package com.mx.testanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mx.testanimation.activity.BlastActivity;
import com.mx.testanimation.activity.BufferFlyActivity;
import com.mx.testanimation.activity.EasyDemo;
import com.mx.testanimation.activity.FrameActivity;
import com.mx.testanimation.activity.ListViewActivity;
import com.mx.testanimation.activity.Main2Activity;
import com.mx.testanimation.activity.NewTextViewActivity;
import com.mx.testanimation.activity.ObjectAnimation2Activity;
import com.mx.testanimation.activity.ObjectAnimatorActivity;
import com.mx.testanimation.activity.ShineTextView;
import com.mx.testanimation.activity.SlideShow;
import com.mx.testanimation.activity.SurfaceViewActivity;
import com.mx.testanimation.activity.TestDialog;
import com.mx.testanimation.activity.TestDrawView;
import com.mx.testanimation.activity.TestView;
import com.mx.testanimation.activity.TopBarActivity;
import com.mx.testanimation.activity.TweenActivity;
import com.mx.testanimation.activity.YouKuMenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
    Button button02, button03, button04, button05, button06, button07, button08, button09, button010;

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

        button6 = findViewById(R.id.activity6);
        button6.setOnClickListener(this);

        button7 = findViewById(R.id.activity7);
        button7.setOnClickListener(this);

        button8 = findViewById(R.id.activity8);
        button8.setOnClickListener(this);

        button9 = findViewById(R.id.activity9);
        button9.setOnClickListener(this);

        button10 = findViewById(R.id.activity10);
        button10.setOnClickListener(this);

        button02 = findViewById(R.id.button2);
        button02.setOnClickListener(this);

        button03 = findViewById(R.id.button3);
        button03.setOnClickListener(this);

        button04 = findViewById(R.id.button4);
        button04.setOnClickListener(this);

        button05 = findViewById(R.id.button5);
        button05.setOnClickListener(this);

        button06 = findViewById(R.id.button6);
        button06.setOnClickListener(this);

        button07 = findViewById(R.id.button7);
        button07.setOnClickListener(this);

        button08 = findViewById(R.id.button8);
        button08.setOnClickListener(this);

        button09 = findViewById(R.id.button9);
        button09.setOnClickListener(this);

        button010 = findViewById(R.id.button10);
        button010.setOnClickListener(this);
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

            case R.id.activity6:
                intent = new Intent(this, ObjectAnimatorActivity.class);
                startActivity(intent);
                break;

            case R.id.activity7:
                intent = new Intent(this, ObjectAnimation2Activity.class);
                startActivity(intent);
                break;

            case R.id.activity8:
                intent = new Intent(this, SurfaceViewActivity.class);
                startActivity(intent);
                break;

            case R.id.activity9:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;

            case R.id.activity10:
                intent = new Intent(this, YouKuMenuActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:
                intent = new Intent(this, SlideShow.class);
                startActivity(intent);
                break;

            case R.id.button3:
                intent = new Intent(this, NewTextViewActivity.class);
                startActivity(intent);
                break;

            case R.id.button4:
                intent = new Intent(this, TopBarActivity.class);
                startActivity(intent);
                break;

            case R.id.button5:
                intent = new Intent(this, EasyDemo.class);
                startActivity(intent);
                break;

            case R.id.button6:
                intent = new Intent(this, ShineTextView.class);
                startActivity(intent);
                break;

            case R.id.button7:
                intent = new Intent(this, TestView.class);
                startActivity(intent);
                break;

            case R.id.button8:
                intent = new Intent(this, TestDrawView.class);
                startActivity(intent);
                break;

            case R.id.button9:
                intent = new Intent(this, TestDialog.class);
                startActivity(intent);
                break;

            case R.id.button10:
                intent = new Intent(this, TestDialog.class);
                startActivity(intent);
                break;


            default:
                break;
        }
    }
}
