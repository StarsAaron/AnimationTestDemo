package com.aaron.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Aaron
 *         <p>
 *         补间动画Xml文件实现
 *
 *       alpha、scale、translate、rotate、set的xml属性及用法
 */
public class TweenActivity extends AppCompatActivity {
    Button alphaBtn;
    Button scaleBtn;
    Button rotateBtn;
    Button translateBtn;
    Button setBtn;

    TextView tv;

    Animation alpaAnimation;
    Animation scaleAnimation;
    Animation rotateAnimation;
    Animation translateAnimation;
    Animation setAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        initCtrl();

        initAnimation();

        initBtnListener();
    }

    private void initCtrl() {
        alphaBtn = (Button) findViewById(R.id.btn_alpha_anim);
        scaleBtn = (Button) findViewById(R.id.btn_scale_anim);
        rotateBtn = (Button) findViewById(R.id.btn_rotate_anim);
        translateBtn = (Button) findViewById(R.id.btn_translate_anim);
        setBtn = (Button) findViewById(R.id.btn_set_anim);
        tv = (TextView) findViewById(R.id.tv);
    }

    private void initAnimation() {
        // 透明度
        alpaAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_alphaanim);
        // 缩放
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_scaleanim);
        // 旋转
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_rotateanim);
        // 平移
        translateAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_translateanim);
        // 组合
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_setanim);
    }

    private void initBtnListener() {
        alphaBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                tv.startAnimation(alpaAnimation);
            }
        });

        scaleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv.startAnimation(scaleAnimation);
            }
        });

        rotateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv.startAnimation(rotateAnimation);
            }
        });

        translateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv.startAnimation(translateAnimation);
            }
        });

        setBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv.startAnimation(setAnimation);
            }
        });
    }
}
