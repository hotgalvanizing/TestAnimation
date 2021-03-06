package com.mx.testanimation.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {

    private float centerX;
    private float centerY;

    private int duration;
    private Camera camera = new Camera();

    public MyAnimation(float centerX, float centerY, int duration) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.duration = duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setDuration(duration);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        camera.save();
        // 根据interpolatedTime时间来控制X、Y、Z上的偏移
        camera.translate(100.0f - 100.0f * interpolatedTime,
                150.0f * interpolatedTime - 150,
                80.0f - 80.0f * interpolatedTime);
        // 设置根据interpolatedTime时间在Y轴上旋转不同角度
        camera.rotateY(360 * (interpolatedTime));
        // 设置根据interpolatedTime时间在X轴上旋转不同角度
        camera.rotateX((360 * interpolatedTime));
        // 获取Transformation参数的Matrix对象
        Matrix matrix = t.getMatrix();
        camera.getMatrix(matrix);
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        camera.restore();
    }
}
