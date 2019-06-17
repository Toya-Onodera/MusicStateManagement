package com.example.ont_macbook.muratasemibackgroundmusicapp;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class MusicStateManagement {
    private Context context;
    private MediaPlayer mp;
    private ArrayList<Integer> musicArray;
    private Integer selectTrackIndex;

    MusicStateManagement (Context _context, ArrayList<Integer> _musicArray, Integer _selectTrackIndex) {
        // 呼び出し元の context を格納する
        context = _context;

        // 音楽データすべてを配列に格納する
        musicArray = _musicArray;

        // 再生する曲インデックスの設定
        selectTrackIndex = _selectTrackIndex;

        // 再生する曲をセットする
        mp = MediaPlayer.create(context, _musicArray.get(_selectTrackIndex));

        // 音楽のループはしないようにする
        mp.setLooping(false);
    }

    // 音楽を再生する
    public void playMusic () {
        if (!mp.isPlaying()) {
            mp.start();
        }
    }

    // 音楽を停止する
    public void stopMusic () {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }

    // 音楽を一時停止する
    public void pauseMusic () {
        if (mp.isPlaying()) {
            mp.pause();
        }
    }

    // 音楽を指定の方向へスキップする
    // 前の曲 -> -1
    // 次の曲 -> +1
    public void skipMusic (int direction) {
        // ひとまず曲のインデックスを取得する
        int skipIndex = selectTrackIndex + direction;

        // インデックスがループできるようにする
        // 0 以下にならないように動作
        if (skipIndex == -1) {
            selectTrackIndex = musicArray.size() - 1;
        }

        // 要素数以上にならないようにする
        else if (skipIndex == musicArray.size()) {
            selectTrackIndex = 0;
        }

        else {
            selectTrackIndex = skipIndex;
        }

        // 曲が流れていたら一旦停止
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }

        // 新しく流す曲をセット
        mp = MediaPlayer.create(context, musicArray.get(selectTrackIndex));
        mp.start();
    }
}
