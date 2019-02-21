package com.mx.testanimation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ListView;

import com.mx.testanimation.view.MyAnimation;
import com.mx.testanimation.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // 获取ListView组件
        ListView list = (ListView) findViewById(R.id.list);
        WindowManager windowManager = (WindowManager)
                getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrice = new DisplayMetrics();
        // 获取屏幕的宽和高
        display.getMetrics(metrice);
        // 设置对ListView组件应用动画
        list.setAnimation(new MyAnimation(metrice.xdpi / 2
                , metrice.ydpi / 2, 3500));
    }
}
