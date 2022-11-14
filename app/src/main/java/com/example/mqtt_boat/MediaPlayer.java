package com.example.mqtt_boat;


import android.app.Application;
import android.content.Context;

import com.dueeeke.videoplayer.BuildConfig;
import com.dueeeke.videoplayer.ijk.IjkPlayerFactory;
import com.dueeeke.videoplayer.player.VideoViewConfig;
import com.dueeeke.videoplayer.player.VideoViewManager;


public class MediaPlayer extends Application {

    private static Context context;
    private static MediaPlayer instance;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        instance = this;

        initDKPlayer();     // 初始化DKPlayer

    }

    public static MediaPlayer getInstance() {
        return instance;
    }

    public static Context getContext(){
        return context;
    }



    private void initDKPlayer(){
        //播放器配置，注意：此为全局配置，按需开启
        VideoViewManager.setConfig(VideoViewConfig.newBuilder()
                .setLogEnabled(BuildConfig.DEBUG)                               // 调试的时候请打开日志，方便排错
                .setPlayerFactory(IjkPlayerFactory.create())                    // 使用ijkPlayer解码, 支持各种方式
//                .setPlayerFactory(ThunderMediaPlayerFactory.create())
//                .setPlayerFactory(ExoMediaPlayerFactory.create())             // 使用ExoPlayer解码, 支持各种方式
//                .setPlayerFactory(AndroidMediaPlayerFactory.create())         // 使用MediaPlayer解码, 支持http(s)，m38u，不支持rtmp
//                .setRenderViewFactory(SurfaceRenderViewFactory.create())
//                .setEnableOrientation(true)
//                .setEnableAudioFocus(false)
//                .setScreenScaleType(VideoView.SCREEN_SCALE_MATCH_PARENT)
//                .setAdaptCutout(false)
//                .setPlayOnMobileNetwork(true)
//                .setProgressManager(new ProgressManagerImpl())
                .build());

//        if (BuildConfig.DEBUG) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
//            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
//        }

    }


}
