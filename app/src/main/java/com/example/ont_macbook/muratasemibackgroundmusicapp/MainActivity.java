package com.example.ont_macbook.muratasemibackgroundmusicapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
