package com.aaron.animationtest.Interpolator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.aaron.animationtest.R;


/**
 * @author Aaron
 * 伸缩动画 XML文件实现
 */
public class ScaleInterpolatorActivity extends AppCompatActivity implements View.OnClickListener {
    Button acceleraterDeceleraterBtn, acceleraterBtn, antipateBtn, antipateOvershotBtn;
    Button bounceBtn, cycleBtn, decelerateBtn, linearBtn, overshotBtn;

    Animation acceleraterDeceleraterAnim, acceleraterAnim, antipateAnim, antipateovershotAnim;
    Animation bounceAnim, cycleAnim, decelerateAnim, linearAnim, overshotAnim;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_interpolator);
        initCtrls();
        initAnim();

        acceleraterDeceleraterBtn.setOnClickListener(this);
        acceleraterBtn.setOnClickListener(this);
        decelerateBtn.setOnClickListener(this);
        antipateBtn.setOnClickListener(this);
        antipateOvershotBtn.setOnClickListener(this);
        bounceBtn.setOnClickListener(this);
        cycleBtn.setOnClickListener(this);
        linearBtn.setOnClickListener(this);
        overshotBtn.setOnClickListener(this);
    }

    private void initCtrls() {
        acceleraterDeceleraterBtn = (Button) findViewById(R.id.btn_AccelerateDecelerate);
        acceleraterBtn = (Button) findViewById(R.id.btn_Accelerate);
        decelerateBtn = (Button) findViewById(R.id.btn_Decelerate);
        antipateBtn = (Button) findViewById(R.id.btn_Anticipate);
        antipateOvershotBtn = (Button) findViewById(R.id.btn_AnticipateOvershoot);
        bounceBtn = (Button) findViewById(R.id.btn_Bounce);
        cycleBtn = (Button) findViewById(R.id.btn_Cycle);
        linearBtn = (Button) findViewById(R.id.btn_Linear);
        overshotBtn = (Button) findViewById(R.id.btn_Overshoot);

        tv = (TextView) findViewById(R.id.tv);
    }

    private void initAnim() {
        acceleraterDeceleraterAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_accelerater_decelerate);
        acceleraterAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_accelerater);
        decelerateAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_decelerate);
        antipateAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_anticipate);
        antipateovershotAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_anticipate_overshot);
        bounceAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_bounce);
        cycleAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_cycle);
        linearAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_linear);
        overshotAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim_scale_overshot);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.equals(acceleraterDeceleraterBtn)) {
            tv.startAnimation(acceleraterDeceleraterAnim);
        } else if (v.equals(acceleraterBtn)) {
            tv.startAnimation(acceleraterAnim);
        } else if (v.equals(decelerateBtn)) {
            tv.startAnimation(decelerateAnim);
        } else if (v.equals(antipateBtn)) {
            tv.startAnimation(antipateAnim);
        } else if (v.equals(antipateOvershotBtn)) {
            tv.startAnimation(antipateovershotAnim);
        } else if (v.equals(bounceBtn)) {
            tv.startAnimation(bounceAnim);
        } else if (v.equals(cycleBtn)) {
            tv.startAnimation(cycleAnim);
        } else if (v.equals(linearBtn)) {
            tv.startAnimation(linearAnim);
        } else if (v.equals(overshotBtn)) {
            tv.startAnimation(overshotAnim);
        }
    }
}
