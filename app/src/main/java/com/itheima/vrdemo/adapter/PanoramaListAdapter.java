package com.itheima.vrdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.itheima.vrdemo.bean.PanoramaItem;
import com.itheima.vrdemo.widget.PanoramaItemView;

import java.util.List;

/**
 * Created by Leon on 2017/2/16.
 */

public class PanoramaListAdapter extends RecyclerView.Adapter<PanoramaListAdapter.PanoramaListItemViewHolder> {

    private Context mContext;
    private List<PanoramaItem> mDataList;

    public PanoramaListAdapter(Context context, List<PanoramaItem> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public PanoramaListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PanoramaListItemViewHolder(new PanoramaItemView(mContext));
    }

    @Override
    public void onBindViewHolder(PanoramaListItemViewHolder holder, int position) {
        holder.mPanoramaListItemView.bindView(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class PanoramaListItemViewHolder extends RecyclerView.ViewHolder {

        private PanoramaItemView mPanoramaListItemView;

        public PanoramaListItemViewHolder(PanoramaItemView itemView) {
            super(itemView);
            mPanoramaListItemView = itemView;
        }
    }
}
