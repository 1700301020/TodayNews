package com.example.todaynews.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.mvp.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0) {
                setContentView(mainLayoutId);
                bindView();
                afterBindView();
            } else {
                throw new RuntimeException("mainLayoutId < 0");
            }
        } else {
            throw new RuntimeException("annotation == null");
        }
    }

    //模板方法设计模式
    public abstract void afterBindView();

    //View的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }
}
