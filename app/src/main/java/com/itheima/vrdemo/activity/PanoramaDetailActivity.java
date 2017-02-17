package com.itheima.vrdemo.activity;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.itheima.vrdemo.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Leon on 2017/2/17.
 */
public class PanoramaDetailActivity extends AppCompatActivity{

    private VrPanoramaView mVrPanoramaView;
    private String mUrl;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama_detail);
        initPanoramaView();
        initMediaPlayer();
    }

    /**
     * 如果有音乐数据则播放音乐
     */
    private void initMediaPlayer() {
        String mp3 = getIntent().getStringExtra("mp3");
        if (mp3 != null) {
            mMediaPlayer = new MediaPlayer();
            try {
                mMediaPlayer.setDataSource(this, Uri.parse(mp3));
                mMediaPlayer.setOnPreparedListener(mOnPreparedListener);
                mMediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mMediaPlayer.start();
        }
    };

    private void initPanoramaView() {
        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.vr_panorama_view);
//        mVrPanoramaView.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_MONO);//全屏模式，弹出一个全屏的Dialog
        mVrPanoramaView.setInfoButtonEnabled(false);//隐藏信息按钮
        mVrPanoramaView.setStereoModeButtonEnabled(false);//隐藏cardboard按钮
        mVrPanoramaView.setFullscreenButtonEnabled(false);//隐藏全屏按钮
        mUrl = getIntent().getStringExtra("url");
        OkGo.get(mUrl).cacheKey(mUrl).tag(mUrl).execute(new BitmapCallback() {

            @Override
            public void onSuccess(Bitmap bitmap, Call call, Response response) {
                VrPanoramaView.Options options = new VrPanoramaView.Options();
                //设置图片类型为单通道图片
                options.inputType = VrPanoramaView.Options.TYPE_MONO;
                mVrPanoramaView.loadImageFromBitmap(bitmap, options);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVrPanoramaView.pauseRendering();
        if (mMediaPlayer != null) {
            mMediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVrPanoramaView.shutdown();
        OkGo.getInstance().cancelTag(mUrl);//取消请求
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
