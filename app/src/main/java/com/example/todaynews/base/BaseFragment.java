package com.example.todaynews.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.todaynews.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    private View mView = null;
    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    //加载fragment的界面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0) {
                mView = initFragmentView(inflater,mainLayoutId);
                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException("mainLayoutId < 0");
            }
        } else {
            throw new RuntimeException("annotation == null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int id) {
        return inflater.inflate(id, null);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //模板方法设计模式
    public abstract void afterBindView();

    //View的依赖注入绑定
    private void bindView(View view) {
        ButterKnife.bind(this,view);
    }
}
