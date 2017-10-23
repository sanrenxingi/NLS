package com.example.dell.quarter.view.activity;

import android.content.Intent;
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

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.utils.Player;

/**
 * 视频播放类
 * 聂雁宾
 */
public class VideoPlayActivity extends BaseActivity {
    private SurfaceView surfaceView;
    private Button btnPause, btnPlayUrl;
    private SeekBar skbProgress;
    private Player player;
    private Button btncb;
    private String url;


    @Override
    int setViewId() {
        return R.layout.activity_video_play;
    }
    @Override
    void initData() {
        player = new Player(surfaceView, skbProgress);
    }
    @Override
    void initView() {
        surfaceView =  this.findViewById(R.id.surfaceView1);

        btnPlayUrl = this.findViewById(R.id.btnPlayUrl);
        btnPlayUrl.setOnClickListener(new ClickEvent());

        btnPause = this.findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new ClickEvent());

        btncb =  this.findViewById(R.id.btncb);
        btncb.setOnClickListener(new ClickEvent());

        skbProgress =  this.findViewById(R.id.skbProgress);
        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
    }

    @Override
    void initLogic() {
        //接收传来的参数
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    class ClickEvent implements OnClickListener {

        @Override
        public void onClick(View arg0) {
            if (arg0 == btnPause) {
                player.pause();
            } else if (arg0 == btnPlayUrl) {
                //连接
                player.playUrl("http://172.17.29.27/oppo.mp4");
            } else if(arg0==btncb){
                player.play();
            }
        }
    }

    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
            this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
            player.mediaPlayer.seekTo(progress);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
