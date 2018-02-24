package com.aaron.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aaron.animationtest.Interpolator.AlphaInterpolatorActivity;
import com.aaron.animationtest.Interpolator.RotateInterpolatorActivity;
import com.aaron.animationtest.Interpolator.ScaleInterpolatorActivity;
import com.aaron.animationtest.Interpolator.TranslateInterpolatorActivity;
import com.aaron.animationtest.propertyAnim.CategoryListActivity;

/**
 * 主页，显示入口
 */
public class AnimationMainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_frame;
    private Button btn_tween;
    private Button btn_interpolator;
    private Button btn_rotate_interpolator;
    private Button btn_scale_interpolator;
    private Button btn_translate_interpolator;
    private Button btn_usecode;
    private Button btn_listener;
    private Button btn_property;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_main);
        initView();
    }

    private void initView() {
        btn_frame = (Button) findViewById(R.id.btn_frame);
        btn_tween = (Button) findViewById(R.id.btn_tween);
        btn_interpolator = (Button) findViewById(R.id.btn_alpha_interpolator);
        btn_rotate_interpolator = (Button) findViewById(R.id.btn_rotate_interpolator);
        btn_scale_interpolator = (Button) findViewById(R.id.btn_scale_interpolator);
        btn_translate_interpolator = (Button) findViewById(R.id.btn_translate_interpolator);
        btn_usecode = (Button) findViewById(R.id.btn_usecode);
        btn_listener = (Button) findViewById(R.id.btn_listener);
        btn_property = (Button) findViewById(R.id.btn_property);

        btn_frame.setOnClickListener(this);
        btn_tween.setOnClickListener(this);
        btn_interpolator.setOnClickListener(this);
        btn_rotate_interpolator.setOnClickListener(this);
        btn_scale_interpolator.setOnClickListener(this);
        btn_translate_interpolator.setOnClickListener(this);
        btn_usecode.setOnClickListener(this);
        btn_listener.setOnClickListener(this);
        btn_property.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_frame) {
            goActivity(FrameActivity.class);
        } else if (v.getId() == R.id.btn_tween) {
            goActivity(TweenActivity.class);
        } else if (v.getId() == R.id.btn_alpha_interpolator) {
            goActivity(AlphaInterpolatorActivity.class);
        } else if (v.getId() == R.id.btn_rotate_interpolator) {
            goActivity(RotateInterpolatorActivity.class);
        } else if (v.getId() == R.id.btn_scale_interpolator) {
            goActivity(ScaleInterpolatorActivity.class);
        } else if (v.getId() == R.id.btn_translate_interpolator) {
            goActivity(TranslateInterpolatorActivity.class);
        } else if (v.getId() == R.id.btn_usecode) {
            goActivity(UseCodeActivity.class);
        } else if (v.getId() == R.id.btn_listener) {
            goActivity(AnimationListenerActivity.class);
        } else if (v.getId() == R.id.btn_property) {
            goActivity(CategoryListActivity.class);
        }
    }

    /**
     * 跳转
     *
     * @param name
     */
    private void goActivity(Class name) {
        Intent intent = new Intent(AnimationMainActivity.this, name);
        startActivity(intent);
    }
}
