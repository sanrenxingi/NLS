package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.utils.Player;
import com.superplayer.library.SuperPlayer;

/**
 * 视频播放类
 * 聂雁宾
 */
public class VideoPlayActivity extends BaseActivity implements View.OnClickListener,SuperPlayer.OnNetChangeListener{
    private String url;
    private boolean isLive;
    private SuperPlayer player;

    @Override
    int setViewId() {
        return R.layout.activity_video_play;
    }
    @Override
    void initData() {
//        player = new Player(surfaceView, skbProgress);
    }
    @Override
    void initView() {
        //接收传来的参数
        Intent intent = getIntent();
        isLive = intent.getBooleanExtra("isLive", false);
        url = intent.getStringExtra("url");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        findViewById(R.id.tv_replay).setOnClickListener(this);
        //初始化视频
        initPlay();
    }

    private void initPlay() {
        player = (SuperPlayer) findViewById(R.id.view_super_player);
        if(isLive){
            player.setLive(true);//设置该地址是直播的地址
        }
        player.setNetChangeListener(true)
                //实现网络变化的回调
                .setOnNetChangeListener(VideoPlayActivity.this)
                .onPrepared(new SuperPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared() {
                        /**
                         * 监听视频是否已经准备完成开始播放。（可以在这里处理视频封面的显示跟隐藏）
                         */
                    }
                }).onComplete(new Runnable() {
            @Override
            public void run() {
                /**
                 * 监听视频是否已经播放完成了。（可以在这里处理视频播放完成进行的操作）
                 */
            }
        }).onInfo(new SuperPlayer.OnInfoListener() {
            @Override
            public void onInfo(int what, int extra) {
                /**
                 * 监听视频的相关信息。
                 */

            }
        }).onError(new SuperPlayer.OnErrorListener() {
            @Override
            public void onError(int what, int extra) {
                /**
                 * 监听视频播放失败的回调
                 */

            }
        }).setTitle(url)//设置视频的titleName
                .play(url);//开始播放视频
        player.setScaleType(SuperPlayer.SCALETYPE_FITXY);
        player.setPlayerWH(0,player.getMeasuredHeight());//设置竖屏的时候屏幕的高度，如果不设置会切换后按照16:9的高度重置
    }

    @Override
    void initLogic() {

    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tv_replay){
            if(player != null){
                player.play(url);
            }
        }
    }

    /**
     * 网络链接监听类
     */
    @Override
    public void onWifi() {
        Toast.makeText(this,"当前网络环境是WIFI",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMobile() {
        Toast.makeText(this,"当前网络环境是手机网络",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisConnect() {
        Toast.makeText(this,"网络链接断开",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoAvailable() {
        Toast.makeText(this,"无网络链接",Toast.LENGTH_SHORT).show();
    }
    //Activity的生命周期
    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
