package com.aaron.animationtest.propertyAnim;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridLayout;

import com.aaron.animationtest.R;


public class LayoutAnimaActivity extends Activity implements
        OnCheckedChangeListener {
    private ViewGroup viewGroup;
    private GridLayout mGridLayout;
    private int mVal;
    private LayoutTransition mTransition;

    private CheckBox mAppear, mChangeAppear, mDisAppear, mChangeDisAppear;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animator);
        viewGroup = (ViewGroup) findViewById(R.id.id_container);

        mAppear = (CheckBox) findViewById(R.id.id_appear);
        mChangeAppear = (CheckBox) findViewById(R.id.id_change_appear);
        mDisAppear = (CheckBox) findViewById(R.id.id_disappear);
        mChangeDisAppear = (CheckBox) findViewById(R.id.id_change_disappear);

        mAppear.setOnCheckedChangeListener(this);
        mChangeAppear.setOnCheckedChangeListener(this);
        mDisAppear.setOnCheckedChangeListener(this);
        mChangeDisAppear.setOnCheckedChangeListener(this);

        // 创建一个GridLayout
        mGridLayout = new GridLayout(this);
        // 设置每列5个按钮
        mGridLayout.setColumnCount(5);
        // 添加到布局中
        viewGroup.addView(mGridLayout);
        // 默认动画全部开启
        mTransition = new LayoutTransition();
        mTransition.setAnimator(LayoutTransition.APPEARING, (mAppear
                .isChecked() ? ObjectAnimator.ofFloat(this, "scaleX", 0, 1)
                : null));
        mGridLayout.setLayoutTransition(mTransition);

    }

    /**
     * 添加按钮
     *
     * @param view
     */
    public void addBtn(View view) {
        final Button button = new Button(this);
        button.setText((++mVal) + "");
        mGridLayout.addView(button, Math.min(1, mGridLayout.getChildCount()));
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mGridLayout.removeView(button);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mTransition = new LayoutTransition();
        mTransition.setAnimator(LayoutTransition.APPEARING, (mAppear
                .isChecked() ? ObjectAnimator.ofFloat(this, "scaleX", 0, 1)
                : null));
        mTransition
                .setAnimator(
                        LayoutTransition.CHANGE_APPEARING,
                        (mChangeAppear.isChecked() ? mTransition
                                .getAnimator(LayoutTransition.CHANGE_APPEARING)
                                : null));
        mTransition.setAnimator(
                LayoutTransition.DISAPPEARING,
                (mDisAppear.isChecked() ? mTransition
                        .getAnimator(LayoutTransition.DISAPPEARING) : null));
        mTransition.setAnimator(
                LayoutTransition.CHANGE_DISAPPEARING,
                (mChangeDisAppear.isChecked() ? mTransition
                        .getAnimator(LayoutTransition.CHANGE_DISAPPEARING)
                        : null));
        mGridLayout.setLayoutTransition(mTransition);
    }
}
