package com.example.todaynews.main;


import androidx.fragment.app.Fragment;

import com.example.mvp.mvp.base.BaseMvpPresenter;
import com.example.todaynews.R;
import com.example.todaynews.main.beijing.BeiJingFragment;
import com.example.todaynews.main.hangzhou.HangZhouFragment;
import com.example.todaynews.main.shanghai.ShangHaiFragment;
import com.example.todaynews.main.shenzhen.ShenZhenFragment;
import com.example.todaynews.main.utils.MainConstantTool;


public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {

    //当前Fragment的角标
    private int mCurrentFragmentIndex;
    //存放fragment的数组
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPosition;

    public MainActivityPresenter(IMainActivityContract.IView iMvpView) {
        super(iMvpView);
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = MainConstantTool.SHANGHAI;
        changeFragment(mCurrentFragmentIndex);
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
    }

    //切换Fragment
    public void changeFragment(int mCurrentFragmentIndex) {
        //隐藏其余fragment
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }

        //获取当前fragment实例
        Fragment fragment = mFragments[mCurrentFragmentIndex];
        if (fragment != null) {
            addAndShowFragment(fragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getCurrentFragmentIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    //记录当前角标
    private void setCurChecked(int index) {
        mCurrentFragmentIndex = index;
        switch (index){
            case MainConstantTool.SHANGHAI:
                mCurrentCheckedId = R.id.rb_main_shanghai;
                mTopPosition = MainConstantTool.SHANGHAI;
                break;
            case MainConstantTool.HANGZHOU:
                mCurrentCheckedId = R.id.rb_main_hangzhou;
                mTopPosition =  MainConstantTool.HANGZHOU;
                break;
            case  MainConstantTool.BEIJING:
                mCurrentCheckedId = R.id.rb_main_beijing;
                mBottomPosition = MainConstantTool.BEIJING;
                break;
            case MainConstantTool.SHENZHEN:
                mCurrentCheckedId = R.id.rb_main_shenzhen;
                mBottomPosition = MainConstantTool.SHENZHEN;
                break;
        }
    }

    //创建新的fragment
    private void newCurrentFragment(int index) {
        Fragment fragment = null;
        switch (index) {
            case MainConstantTool.SHANGHAI:
                fragment = new ShangHaiFragment();
                break;
            case MainConstantTool.HANGZHOU:
                fragment = new HangZhouFragment();
                break;
            case MainConstantTool.BEIJING:
                fragment = new BeiJingFragment();
                break;
            case MainConstantTool.SHENZHEN:
                fragment = new ShenZhenFragment();
                break;
        }
        //添加到数组
        mFragments[index] = fragment;
        //显示
        if (fragment != null) {
            addAndShowFragment(fragment);
        }
    }

    //显示fragment
    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()){
            getView().showFragment(fragment);
        }else {
            getView().addFragment(fragment);
        }
    }

    //隐藏当前Fragment
    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()){
            getView().hideFragment(fragment);
        }
    }
}
