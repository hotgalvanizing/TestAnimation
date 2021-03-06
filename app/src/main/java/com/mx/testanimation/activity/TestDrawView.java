package com.mx.testanimation.activity;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.mx.testanimation.R;
import com.mx.testanimation.view.DrawView;

public class TestDrawView extends AppCompatActivity {

    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout line = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();

        // 获取创建的宽度和高度
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        // 创建一个DrawView，该DrawView的宽度、高度与该Activity保持相同
        drawView = new DrawView(this, displayMetrics.widthPixels
                , displayMetrics.heightPixels);
        line.addView(drawView);
        setContentView(line);

        emboss = new EmbossMaskFilter(new float[]
                {1.5f, 1.5f, 1.5f}, 0.6f, 6, 4.2f);
        blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }

    /**
     * 负责创建选项菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        // 装载R.menu.my_menu对应的菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        // 判断单击的是哪个菜单项，并有针对性地作出响应
        switch (mi.getItemId()) {
            case R.id.red:
                drawView.paint.setColor(Color.RED);
                mi.setChecked(true);
                break;
            case R.id.green:
                drawView.paint.setColor(Color.GREEN);
                mi.setChecked(true);
                break;
            case R.id.blue:
                drawView.paint.setColor(Color.BLUE);
                mi.setChecked(true);
                break;
            case R.id.width_1:
                drawView.paint.setStrokeWidth(1);
                break;
            case R.id.width_3:
                drawView.paint.setStrokeWidth(3);
                break;
            case R.id.width_5:
                drawView.paint.setStrokeWidth(5);
                break;
            case R.id.blur:
                drawView.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
                drawView.paint.setMaskFilter(emboss);
                break;
        }


        return true;
    }
}
