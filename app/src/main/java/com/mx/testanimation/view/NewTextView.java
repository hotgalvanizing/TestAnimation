package com.mx.testanimation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * @author: lhe
 * @date: 2018/08/29
 * @desctiption: xxxx
 */
public class NewTextView extends android.support.v7.widget.AppCompatTextView {

    Paint mPaint1;
    Paint mPaint2;

    public NewTextView(Context context) {
        super(context);
        initView();
    }

    public NewTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NewTextView(Context context, AttributeSet attrs,
                       int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制外层矩形
        canvas.drawRect(
                0,
                0,
                getMeasuredWidth(),
                getMeasuredHeight(),
                mPaint1);

        //绘制内层矩形
        canvas.drawRect(
                10,
                10,
                getMeasuredWidth() - 10,
                getMeasuredHeight() - 10,
                mPaint2);
        canvas.save();

        //绘制文字前平移10像素
        canvas.translate(10, 0);

        super.onDraw(canvas);

        canvas.restore();
    }

    /**
     * 初始化两个画笔
     */
    private void initView() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(
                android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }
}
