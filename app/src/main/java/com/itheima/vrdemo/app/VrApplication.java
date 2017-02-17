package com.itheima.vrdemo.app;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;

/**
 * Created by Leon on 2017/2/17.
 */

public class VrApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.init(this);
        OkGo.getInstance().setCacheMode(CacheMode.IF_NONE_CACHE_REQUEST);
    }
}
