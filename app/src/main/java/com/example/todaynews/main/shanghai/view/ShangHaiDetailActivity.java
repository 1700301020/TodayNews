package com.example.todaynews.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.todaynews.R;
import com.example.todaynews.base.BaseActivity;
import com.example.todaynews.base.ViewInject;
import com.example.todaynews.main.shanghai.manager.GetJokeManager;
import com.example.todaynews.main.shanghai.module.ShangHaiDetailHttpTask;
import com.example.todaynews.main.shanghai.presenter.ShanghaiDetailPresenter;
import com.example.todaynews.main.shanghai.protocol.IShanghaiDetailContract;

import butterknife.BindView;
import okhttp3.Request;
import okhttp3.Response;

@ViewInject(mainLayoutId = R.layout.activity_main_shanghai_detail)
public class ShangHaiDetailActivity extends BaseActivity implements IShanghaiDetailContract.IView {

    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);
    public static String str = "ActivityOptionsCompat";
    @BindView(R.id.iv_activity_shanghai_detail)
    ImageView ivActivityShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnima();
        initGetNetData();
    }

    //发送网络请求
    private void initGetNetData() {
        mPresenter.getNetData();
    }

    private void initAnima() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ViewCompat.setTransitionName(ivActivityShanghaiDetail,str);
            //开启转场动画
            startPostponedEnterTransition();
        }
    }

    //界面转场动画 共享元素动画
    public static void start_5_0(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(activity, ShangHaiDetailActivity.class);
            Pair<View, String> pair = new Pair<>(view, str);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}
