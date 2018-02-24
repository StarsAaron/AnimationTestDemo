package com.aaron.animationtest;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Aaron
 *         <p>
 *         Frame 动画演示
 *         <p>
 *         (1)先在drawable文件夹下新建一个xml
 *         内容格式：
 *         <animation-list xmlns:android="http://schemas.android.com/apk/res/android"
 *                     android:oneshot=["true" | "false"]>
 *              <item android:drawable="@[package:]drawable/drawable_resource_name"
 *                    android:duration="integer" />
 *         </animation-list>
 *         （2）设置使用Frame动画的控件
 *         setBackgroundResource(R.drawable.frame_animation);
 *         （3）从控件获取AnimationDrawable 对象，进行播放和停止等操作
 */
public class FrameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_play;
    private Button btn_stop;
    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.frame_animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (animationDrawable != null) {
            if(v.getId()==R.id.btn_play){
                animationDrawable.start();//播放动画
            }else{
                animationDrawable.stop();//停止动画
            }
        }
    }
}
