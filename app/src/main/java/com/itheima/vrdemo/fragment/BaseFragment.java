package com.itheima.vrdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.vrdemo.R;

/**
 * Created by Leon on 2017/2/16.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_base_fragment, null);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(getLayoutManager());
        return root;
    }

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract RecyclerView.LayoutManager getLayoutManager();
}
