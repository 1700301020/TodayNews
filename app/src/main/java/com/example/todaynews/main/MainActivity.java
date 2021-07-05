package com.example.todaynews.main;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.todaynews.R;
import com.example.todaynews.base.BaseActivity;
import com.example.todaynews.base.ViewInject;
import com.example.todaynews.main.utils.MainConstantTool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView{

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
    private boolean isChangeTopOrBottom;
    private IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @Override
    public void afterBindView() {
        initHomeFragment();
        initCheckedListener();
        changeAnima(rgMainBottom,rgMainTop);
    }

    private void initCheckedListener() {
        rbMainShanghai.setChecked(true);
        rgMainTop.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == mPresenter.getCurrentCheckedId()){
                return;
            }
            switch (checkedId){
                case R.id.rb_main_shanghai:
                    mPresenter.changeFragment(MainConstantTool.SHANGHAI);
                    break;
                case R.id.rb_main_hangzhou:
                    mPresenter.changeFragment(MainConstantTool.HANGZHOU);
                    break;
            }
        });

        rgMainBottom.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == mPresenter.getCurrentCheckedId()) {
                return;
            }
            switch (checkedId){
                case R.id.rb_main_beijing:
                    mPresenter.changeFragment(MainConstantTool.BEIJING);
                    break;
                case R.id.rb_main_shenzhen:
                    mPresenter.changeFragment(MainConstantTool.SHENZHEN);
                    break;
            }
        });
    }

    //初始化Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick(R.id.fab_main)
    public void onClick(View view) {
        Log.d("MainActivity","点击");
        switch (view.getId()){
            case R.id.fab_main:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnima(rgMainTop,rgMainBottom);
                    TopChangeBottom();
                }else {
                    changeAnima(rgMainBottom,rgMainTop);
                    BottomChangeTop();
                }
                break;
        }
    }

    //北京 深圳 -> 上海 杭州
    private void BottomChangeTop() {
        if (mPresenter.getTopPosition() != MainConstantTool.HANGZHOU){
            mPresenter.changeFragment(MainConstantTool.SHANGHAI);
            rbMainShanghai.setChecked(true);
        }else {
            mPresenter.changeFragment(MainConstantTool.HANGZHOU);
            rbMainHangzhou.setChecked(true);
        }
    }

    //上海 杭州 -> 北京 深圳
    private void TopChangeBottom() {
        if (mPresenter.getBottomPosition() != MainConstantTool.SHENZHEN){
            mPresenter.changeFragment(MainConstantTool.BEIJING);
            rbMainBeijing.setChecked(true);
        }else {
            mPresenter.changeFragment(MainConstantTool.SHENZHEN);
            rbMainShenzhen.setChecked(true);
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

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_top,fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }
}