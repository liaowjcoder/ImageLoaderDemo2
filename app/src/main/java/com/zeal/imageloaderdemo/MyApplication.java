package com.zeal.imageloaderdemo;

import android.app.Application;

import com.zeal.lib.ImageLoaderUtils;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/20 11:05
 * @描述 ${TODO} 
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initImageLoaderConfigration();
    }

    public void initImageLoaderConfigration() {
//        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder
//                (getApplicationContext()).denyCacheImageMultipleSizesInMemory()//拒绝多个尺寸的缓存
//                .threadPriority(Thread.NORM_PRIORITY - 2).memoryCacheSize(2 * 1024 * 1024)
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .writeDebugLogs()
//                .diskCacheFileNameGenerator(new Md5FileNameGenerator()).memoryCache(new
//                        WeakMemoryCache()).build();
//        ImageLoader.getInstance().init(configuration);

        ImageLoaderUtils.getInstance(getApplicationContext()).init();
    }
}
