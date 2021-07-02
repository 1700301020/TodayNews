package com.example.todaynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private FullScreenVideoView mVideoView;
    private TextView mTextViewTimer;
    private CustomCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = findViewById(R.id.vv_play);
        mTextViewTimer = findViewById(R.id.tv_splash_timer);
        mTextViewTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
        mVideoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator+R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mTextViewTimer.setText(time+"秒");
            }

            @Override
            public void onFinish() {
                mTextViewTimer.setText("跳过");
            }
        });

        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}