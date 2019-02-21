package com.mx.testanimation.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mx.testanimation.R;

/**
 * @author: lhe
 * @date: 2018/12/12
 * @desctiption: xxxx
 */
public class CustomerView extends RelativeLayout {

    private ImageView image_show;
    private ImageView image_jian;
    private ImageView image_report;
    private ImageView image_copy;
    private ImageView image_pingbi;

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.customer, this, false);
        image_show = view.findViewById(R.id.image_show);
        image_jian = view.findViewById(R.id.image_jian);
        image_report = view.findViewById(R.id.image_report);
        image_copy = view.findViewById(R.id.image_copy);
        image_pingbi = view.findViewById(R.id.image_pingbi);

        //加号按钮的点击事件,展示另外三张图片
        image_show.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                image_jian.setVisibility(View.VISIBLE);
                image_show.setVisibility(View.GONE);
                showMenu();
            }
        });

        //减号的点击事件,隐藏另外三张图片
        image_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                image_jian.setVisibility(View.GONE);
                image_show.setVisibility(View.VISIBLE);
                hideMenu();
            }
        });

        addView(view);
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //属性动画,,展示出来
    public void showMenu() {
        //三个平移动画 平移出来
        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(image_pingbi
                , "translationY", 0, -65 *3);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy
                , "translationY", 0, -65 * 2);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_report
                , "translationY", 0, -65 * 1);

        //旋转动画
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(image_jian, "rotation", 0, 135, 0);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(image_report, "rotation", 0, 180, 0);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(image_copy, "rotation", 0, 180, 0);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(image_pingbi, "rotation", 0, 180, 0);

        //组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);//动画时长
//        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.setInterpolator(new DecelerateInterpolator());
        //设置动画一起播放
        animatorSet.playTogether(rotation1,rotation2,rotation3,rotation4,firstAnimator,secondAnimator,thirdAnimator);

        animatorSet.start();

    }

    public void hideMenu() {
        //三个平移回去
        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(image_pingbi
                , "translationY", image_report.getTranslationY(), 0);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy
                , "translationY", image_copy.getTranslationY(), 0);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_report
                , "translationY", image_pingbi.getTranslationY(), 0);
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(image_show, "rotation", 0, 135, 0);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(image_copy, "rotation", 0, 180, 0);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(image_pingbi, "rotation", 0, 180, 0);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(image_report, "rotation", 0, 180, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);
//        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(rotation1,rotation2,rotation3,rotation4,firstAnimator,secondAnimator,thirdAnimator);
//        animatorSet.playTogether(firstAnimator, secondAnimator, thirdAnimator);
//        animatorSet.playTogether(firstAnimator);

        animatorSet.start();
    }


}
