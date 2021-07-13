package com.example.todaynews.main.shanghai.presenter;

import android.util.Log;

import com.example.http.result.IResult;
import com.example.mvp.mvp.base.BaseMvpPresenter;
import com.example.task.LfTask;
import com.example.todaynews.base.BasePresenter;
import com.example.todaynews.base.JuHeTask;
import com.example.todaynews.main.shanghai.dto.ShangHaiDetailBean;
import com.example.todaynews.main.shanghai.module.ShangHaiDetailHttpTask;
import com.example.todaynews.main.shanghai.protocol.IShanghaiDetailContract;

import java.io.IOException;

import okhttp3.Response;

public class ShanghaiDetailPresenter extends BasePresenter<IShanghaiDetailContract.IView> implements IShanghaiDetailContract.IPresenter {

    public ShanghaiDetailPresenter(IShanghaiDetailContract.IView iMvpView) {
        super(iMvpView);
    }

    @Override
    protected IShanghaiDetailContract.IView getEmptyView() {
        return IShanghaiDetailContract.emptyView;
    }

    @Override
    public void getNetData() {
        submitTask(new JuHeTask<ShangHaiDetailBean>() {
            //在子线程中运行
            @Override
            public IResult<ShangHaiDetailBean> onBackground() {
                return new ShangHaiDetailHttpTask<ShangHaiDetailBean>().getJokeList("desc","1","2");
            }

            @Override
            public void onSuccess(IResult<ShangHaiDetailBean> t) {
                ShangHaiDetailBean data = t.getData();
                Log.d("getNetData","errorCode -> " + data.errorCode + " reason --> " + data.reason);
                Log.d("getNetData","result -> " + data.result);
            }
        });
    }
}
