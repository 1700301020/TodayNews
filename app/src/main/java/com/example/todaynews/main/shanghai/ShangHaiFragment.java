package com.example.todaynews.main.shanghai;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaynews.R;
import com.example.todaynews.base.BaseFragment;
import com.example.todaynews.base.ViewInject;
import com.example.todaynews.main.shanghai.adapter.ShanghaiAdapter;
import com.example.todaynews.main.shanghai.dto.ShanghaiBeanDataManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {

    @BindView(R.id.tv_main_fragment_shanghai_top)
    TextView mTvMainShanghaiTop;
    @BindView(R.id.abl_main_shanghai)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.ctl_main_shanghai)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.rv_main_shanghai)
    RecyclerView mRecyclerView;

    @Override
    public void afterBindView() {
        initRecyclerView();
        initListener();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new ShanghaiAdapter(getActivity(), ShanghaiBeanDataManager.getData(), false));
    }

    private void initListener() {
        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            Log.d("ShangHaiFragment","verticalOffset = "+verticalOffset + "appBarLayout -> "+ appBarLayout.getMeasuredHeight());
            //滑动距离超过appBarLayout的高度的一半，标题就显示
            if (-verticalOffset < appBarLayout.getMeasuredHeight()/2){
                mTvMainShanghaiTop.setVisibility(View.INVISIBLE);
            }else {
                mTvMainShanghaiTop.setVisibility(View.VISIBLE);
            }
        });
    }
}
