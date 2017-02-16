package com.itheima.vrdemo;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Leon on 2017/2/16.
 */

public class PanoramaActivity extends AppCompatActivity {

    private VrPanoramaView mVrPanoramaView;
    private LoadPanoramaImageTask mLoadPanoramaImageTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama);
        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.panorama_view);
        mVrPanoramaView.setEventListener(mVrPanoramaEventListener);
        mLoadPanoramaImageTask = new LoadPanoramaImageTask();
        mLoadPanoramaImageTask.execute();
    }

    private VrPanoramaEventListener mVrPanoramaEventListener = new VrPanoramaEventListener() {
        /**
         * 点击回调
         */
        @Override
        public void onClick() {
            super.onClick();
        }

        /**
         * 加载数据成功回调
         */
        @Override
        public void onLoadSuccess() {
            super.onLoadSuccess();
        }

        /**
         * 加载数据失败回调
         */
        @Override
        public void onLoadError(String errorMessage) {
            super.onLoadError(errorMessage);
        }
    };


    private class LoadPanoramaImageTask extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                AssetManager assetManager = getAssets();
                InputStream open = assetManager.open("andes.jpg");
                return BitmapFactory.decodeStream(open);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            VrPanoramaView.Options options = new VrPanoramaView.Options();
            options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
            mVrPanoramaView.loadImageFromBitmap(bitmap, options);
        }
    }

    @Override
    protected void onPause() {
        mVrPanoramaView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        // Destroy the widget and free memory.
        mVrPanoramaView.shutdown();
        // The background task has a 5 second timeout so it can potentially stay alive for 5 seconds
        // after the activity is destroyed unless it is explicitly cancelled.
        if (mLoadPanoramaImageTask != null) {
            mLoadPanoramaImageTask.cancel(true);
        }
        super.onDestroy();
    }
}
