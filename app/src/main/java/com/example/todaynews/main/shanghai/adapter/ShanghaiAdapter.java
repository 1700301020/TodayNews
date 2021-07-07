package com.example.todaynews.main.shanghai.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaynews.R;
import com.example.todaynews.main.shanghai.dto.ShanghaiBean;
import com.example.todaynews.main.shanghai.view.ShanghaiDetailActivity;

import java.util.ArrayList;

public class ShanghaiAdapter extends RecyclerView.Adapter {

    private boolean mIsHorizontal;
    private Activity mContext;
    private ArrayList<ShanghaiBean> mData;
    private final RecyclerView.RecycledViewPool mRecycledViewPool;

    public ShanghaiAdapter(Activity context, ArrayList<ShanghaiBean> data, boolean isHorizontal) {
        this.mData = data;
        this.mContext = context;
        this.mIsHorizontal = isHorizontal;
        mRecycledViewPool = new RecyclerView.RecycledViewPool();
    }

    //创建View 然后进行缓存
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL) {
            if (mIsHorizontal) {
                Log.d("onCreateViewHolder","vertical");
            }
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_shanghai_content, parent,false);
            ShanghaiViewHolderVertical viewHolderVertical = new ShanghaiViewHolderVertical(view);
            return viewHolderVertical;
        } else if (viewType == ShanghaiBean.IShanghaiItemType.HORIZONTAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_shanghai_horizontal, null);
            ShanghaiViewHolderHorizontal viewHolderHorizontal = new ShanghaiViewHolderHorizontal(view);
            return viewHolderHorizontal;
        } else {
            return null;
        }
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShanghaiBean shanghaiBean = mData.get(position);
        if (holder instanceof ShanghaiViewHolderVertical) {
            ((ShanghaiViewHolderVertical) holder).mTv.setText(shanghaiBean.getDec());
            ((ShanghaiViewHolderVertical) holder).mIv.setVisibility(shanghaiBean.isShowImg() ? View.VISIBLE:View.GONE);
            ((ShanghaiViewHolderVertical) holder).itemView.setTag(position);
        }else if (holder instanceof ShanghaiViewHolderHorizontal){
            ((ShanghaiViewHolderHorizontal) holder).mRv.setAdapter(new ShanghaiAdapter(mContext,shanghaiBean.getData(),true));
        }
    }

    //返回条目数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //获取item类型
    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemType();
    }

    //缓存View  内存友好设计
    public class ShanghaiViewHolderVertical extends RecyclerView.ViewHolder {

        public ImageView mIv;
        public TextView mTv;

        public ShanghaiViewHolderVertical(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_tv_fragment_shanghai);
            mIv = itemView.findViewById(R.id.item_iv_fragment_shanghai);
            itemView.setOnClickListener(v -> {
                ShanghaiDetailActivity.start_5_0(mContext,mIv);
            });
        }
    }

    public class ShanghaiViewHolderHorizontal extends RecyclerView.ViewHolder {

        public RecyclerView mRv;

        public ShanghaiViewHolderHorizontal(View itemView) {
            super(itemView);
            mRv = itemView.findViewById(R.id.item_rv_fragment_shanghai_horizontal);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            layoutManager.setRecycleChildrenOnDetach(true);//设置各个RecyclerView的子view在被回收时可以共用
            mRv.setLayoutManager(layoutManager);
            mRv.setRecycledViewPool(mRecycledViewPool);
        }
    }
}
