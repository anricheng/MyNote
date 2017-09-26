/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.hui.template;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * com.example.hui.template
 * Created by Aric on 下午2:47.
 */

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("aric.db", null,null);

        ContentValues cv = new ContentValues();
        cv.put("zhou","haifeng");
        Animator animator = new Animator() {
            @Override
            public long getStartDelay() {
                return 0;
            }

            @Override
            public void setStartDelay(long startDelay) {

            }

            @Override
            public Animator setDuration(long duration) {
                return null;
            }

            @Override
            public long getDuration() {
                return 0;
            }

            @Override
            public void setInterpolator(TimeInterpolator value) {

            }

            @Override
            public boolean isRunning() {
                return false;
            }
        };

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);

//这里的pointF是一个泛型
        ValueAnimator valueAnimator1 = ValueAnimator.ofObject(new TypeEvaluator<PointF>() {
            /**
             *
             * @param fraction  这是一个时间变化因子，从0到1变化。这个参数用于表示动画的完成度的，
             *                  我们应该根据它来计算当前动画的值应该是多少
             * @param startValue 这是开始的值
             * @param endValue 这是结束的值
             * @return 整个函数的作用就是根据时间变化因子 以及开始值和结束值去计算在时间变化到某个百分值的时候
             * 此时这个动画的值应该是多少
             */
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                return null;
            }
        });

        valueAnimator.setDuration(5000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //这个的返回是一个Object类型，所以要想进行类型转换就必须使用包装类Integer/Float
                Integer animatedValue = (Integer)animation.getAnimatedValue();

            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}


