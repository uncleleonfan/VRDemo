package com.itheima.vrdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.vrdemo.R;
import com.itheima.vrdemo.bean.PanoramaItem;

/**
 * Created by Leon on 2017/2/16.
 */

public class PanoramaItemView extends RelativeLayout {

    private TextView mTitle;
    private ImageView mIcon;

    public PanoramaItemView(Context context) {
        this(context, null);
    }

    public PanoramaItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_panorama, this);
        mTitle = (TextView) findViewById(R.id.title);
        mIcon = (ImageView) findViewById(R.id.icon);
    }

    public void bindView(PanoramaItem panoramaItem) {
        mTitle.setText(panoramaItem.title);
        Glide.with(getContext()).load(panoramaItem.url).into(mIcon);
    }
}
