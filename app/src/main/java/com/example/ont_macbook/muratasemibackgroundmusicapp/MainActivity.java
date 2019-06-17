package com.example.ont_macbook.muratasemibackgroundmusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // 音楽再生クラス
    private MusicStateManagement msm = null;

    // 音楽データを格納する配列
    final private ArrayList<Integer> musicArray = new ArrayList<>(
            Arrays.asList(R.raw.music_01, R.raw.music_02, R.raw.music_03)
    );

    // 音楽選択ボタンのクリックリスナー
    private View.OnClickListener onMusicStateButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            msm = new MusicStateManagement(getApplicationContext(), musicArray, 0);
        }
    };

    // 再生のクリックリスナー
    private View.OnClickListener onPlayButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (msm != null) {
                msm.playMusic();
            }
        }
    };

    // 停止のクリックリスナー
    private View.OnClickListener onStopButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (msm != null) {
                msm.stopMusic();
                msm = null;
            }
        }
    };

    // 一時停止のクリックリスナー
    private View.OnClickListener onPauseButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (msm != null) {
                msm.pauseMusic();
            }
        }
    };

    // 曲送りのクリックリスナー
    private View.OnClickListener onNextButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (msm != null) {
                msm.skipMusic(1);
            }
        }
    };

    // 曲戻しのクリックリスナー
    private View.OnClickListener onBackButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (msm != null) {
                msm.skipMusic(-1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 音楽の選択を行うボタン
        ImageView musicStateButton = (ImageView) findViewById(R.id.imageView_MusicState);
        musicStateButton.setOnClickListener(onMusicStateButtonClickListener);

        // 再生を行うボタン
        ImageView musicPlayButton = (ImageView) findViewById(R.id.imageView_StartButton);
        musicPlayButton.setOnClickListener(onPlayButtonClickListener);

        // 停止を行うボタン
        ImageView musicStopButton = (ImageView) findViewById(R.id.imageView_StopButton);
        musicStopButton.setOnClickListener(onStopButtonClickListener);

        // 一時停止の選択を行うボタン
        ImageView musicSPauseButton = (ImageView) findViewById(R.id.imageView_PauseButton);
        musicSPauseButton.setOnClickListener(onPauseButtonClickListener);

        // 曲送りの選択を行うボタン
        ImageView musicNextButton = (ImageView) findViewById(R.id.imageView_NextButton);
        musicNextButton.setOnClickListener(onNextButtonClickListener);

        // 曲戻しの選択を行うボタン
        ImageView musicBackButton = (ImageView) findViewById(R.id.imageView_BackButton);
        musicBackButton.setOnClickListener(onBackButtonClickListener);
    }
}
