package com.itheima.vrdemo.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itheima.vrdemo.adapter.PanoramaListAdapter;
import com.itheima.vrdemo.utils.PanoramaProvider;

/**
 * Created by Leon on 2017/2/16.
 */

public class PanoramaListFragment extends BaseFragment {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new PanoramaListAdapter(getContext(), PanoramaProvider.getDataList());
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }
}
