package com.example.dell.quarter.modle.utils;

import android.media.MediaPlayer;

/**
 * Created by dell on 2017/10/23.
 */

public class VideoPlay {
    private static MediaPlayer mediaPlayer;
    public static MediaPlayer playVideo(){
        if(mediaPlayer==null){
            synchronized (MediaPlayer.class){
                if(mediaPlayer==null){
                    mediaPlayer=new MediaPlayer();
                }
            }
        }
        return  mediaPlayer;
    }
}
