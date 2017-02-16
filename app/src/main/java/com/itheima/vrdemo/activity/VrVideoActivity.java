package com.itheima.vrdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.itheima.vrdemo.R;

import java.io.IOException;

/**
 * Created by Leon on 2017/2/16.
 */

public class VrVideoActivity extends AppCompatActivity {

    private VrVideoView mVrVideoView;
    private boolean isPaused = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mVrVideoView = (VrVideoView) findViewById(R.id.vr_video_view);
        mVrVideoView.setEventListener(mVrEventListener);

        VrVideoView.Options options = new VrVideoView.Options();
        options.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
        try {
            mVrVideoView.loadVideoFromAsset("congo.mp4", options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VrVideoEventListener mVrEventListener = new VrVideoEventListener() {

        @Override
        public void onLoadError(String errorMessage) {
            Toast.makeText(VrVideoActivity.this, "onLoadError", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoadSuccess() {
            Toast.makeText(VrVideoActivity.this, "onLoadSuccess", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNewFrame() {
        }

        @Override
        public void onCompletion() {
            Toast.makeText(VrVideoActivity.this, "onCompletion", Toast.LENGTH_SHORT).show();
            mVrVideoView.seekTo(0);//播放结束后重新开始播放
        }

        @Override
        public void onClick() {
            togglePause();//点击暂停或者播放
        }
    };

    private void togglePause() {
        if (isPaused) {
            mVrVideoView.playVideo();
        } else {
            mVrVideoView.pauseVideo()
            ;
        }
        isPaused = !isPaused;
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Prevent the view from rendering continuously when in the background.
        mVrVideoView.pauseRendering();
        // If the video is playing when onPause() is called, the default behavior will be to pause
        // the video and keep it paused when onResume() is called.
        isPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVrVideoView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        // Destroy the widget and free memory.
        mVrVideoView.shutdown();
        super.onDestroy();
    }


}
