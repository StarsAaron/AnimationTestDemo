package com.aaron.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Aaron
 *
 * 动画监听
 */
public class AnimationListenerActivity extends AppCompatActivity {
    private ImageView iv_listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_listener);

        iv_listener = (ImageView)findViewById(R.id.iv_listener);
        AnimationSet as=new AnimationSet(true);
        RotateAnimation al=new RotateAnimation(0,-720, Animation.RELATIVE_TO_PARENT
                ,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
        al.setDuration(3000);
        al.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                Toast.makeText(AnimationListenerActivity.this,"动画开启",Toast.LENGTH_SHORT).show();
            }
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(AnimationListenerActivity.this,"动画结束",Toast.LENGTH_SHORT).show();
            }
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(AnimationListenerActivity.this,"动画重播",Toast.LENGTH_SHORT).show();
            }
        });
        as.addAnimation(al);
        iv_listener.startAnimation(as);
    }
}
