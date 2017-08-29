package com.bawei.myapplication;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import org.xutils.x;

/**
 * Created by 蒋六六 on 2017/8/29.
 */

public class Mya extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        xutil();
        Imagelo();

    }
    private void Imagelo() {
        DisplayImageOptions opin=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
        ImageLoaderConfiguration con =new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(opin)
                .build();
        ImageLoader.getInstance().init(con);
    }

    private void xutil() {
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
