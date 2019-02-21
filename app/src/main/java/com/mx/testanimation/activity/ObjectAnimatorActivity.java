package com.mx.testanimation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.mx.testanimation.R;
import com.mx.testanimation.view.ShapeHolder;

import java.util.ArrayList;
import java.util.List;

public class ObjectAnimatorActivity extends AppCompatActivity {

    static final float BALL_SIZE = 50F;

    static final float FULL_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        LinearLayout linearLayout = findViewById(R.id.container);
        linearLayout.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View implements ValueAnimator.AnimatorUpdateListener {

        public final List<ShapeHolder> balls = new ArrayList();

        public MyAnimationView(Context context) {
            super(context);
            setBackgroundColor(Color.WHITE);
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            this.invalidate();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if (event.getAction() != MotionEvent.ACTION_DOWN &&
                    event.getAction() != MotionEvent.ACTION_MOVE) {
                return false;
            }
            //在事件发生点添加一个小球（用一个圆形代表）
            ShapeHolder newBall = addBall(event.getX(), event.getY());

            float startY = newBall.getY();

            float endY = getHeight() - BALL_SIZE;

            float h = getHeight();

            float eventY = event.getY();

            int durtion = (int) (FULL_TIME * ((h - eventY) / h));

            ValueAnimator fallAnim = ObjectAnimator.ofFloat(newBall, "y", startY, endY);

            fallAnim.setDuration(durtion);

            fallAnim.setInterpolator(new AccelerateDecelerateInterpolator());

            fallAnim.addUpdateListener(this);

            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f);
            fadeAnim.setDuration(250);

            fadeAnim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    balls.remove(((ObjectAnimator) animation).getTarget());
                }
            });
            fadeAnim.addUpdateListener(this);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(fallAnim).before(fadeAnim);
            animatorSet.start();
            return true;
        }

        private ShapeHolder addBall(float x, float y) {

            OvalShape circle = new OvalShape();
            circle.resize(BALL_SIZE, BALL_SIZE);

            ShapeDrawable drawable = new ShapeDrawable(circle);
            ShapeHolder shapeHolder = new ShapeHolder(drawable);
            shapeHolder.setX(x - BALL_SIZE / 2);
            shapeHolder.setY(y - BALL_SIZE / 2);

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            // 将red、green、blue三个随机数组合成ARGB颜色
            int color = 0xff000000 + red << 16 | green << 8 | blue;
            // 获取drawable上关联的画笔
            Paint paint = drawable.getPaint();
            // 将red、green、blue三个随机数除以4得到商值组合成ARGB颜色
            int darkColor = 0xff000000 | red / 4 << 16
                    | green / 4 << 8 | blue / 4;
            // 创建圆形渐变
            RadialGradient gradient = new RadialGradient(
                    37.5f, 12.5f, BALL_SIZE, color, darkColor
                    , Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            // 为shapeHolder设置paint画笔
            shapeHolder.setPaint(paint);
            balls.add(shapeHolder);
            return shapeHolder;

        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            // 遍历balls集合中的每个ShapeHolder对象
            for (ShapeHolder shapeHolder : balls)
            {
                // 保存canvas的当前坐标系统
                canvas.save();
                // 坐标变换：将画布坐标系统平移到shapeHolder的X、Y坐标处
                canvas.translate(shapeHolder.getX()
                        , shapeHolder.getY());
                // 将shapeHolder持有的圆形绘制在Canvas上
                shapeHolder.getShape().draw(canvas);
                // 恢复Canvas坐标系统
                canvas.restore();
            }
        }
    }
}
