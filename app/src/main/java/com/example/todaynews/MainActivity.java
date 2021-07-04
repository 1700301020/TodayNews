package com.example.todaynews;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.fab_main)
    FloatingActionButton fabMain;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.rb_main_beijing)
    RadioButton rbMainBeijing;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    private boolean isChangeTopOrBottom = true;

    @Override
    public void afterBindView() {
        changeAnima(rgMainBottom,rgMainTop);
    }

    @OnClick(R.id.fab_main)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_main:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnima(rgMainBottom,rgMainTop);
                }else {
                    changeAnima(rgMainTop,rgMainBottom);
                }
                break;
        }
    }


    //动画
    private void changeAnima(RadioGroup gone, RadioGroup show) {
        //消失的动画
        gone.clearAnimation();//清除自身动画
        Animation animationGone = AnimationUtils.loadAnimation(this,R.anim.main_rg_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        //出现的动画
        show.clearAnimation();//清除自身动画
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_rg_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }
}