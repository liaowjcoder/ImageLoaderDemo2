package com.zeal.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/22 10:12
 * @描述 图片加载器工具类
 */

public class ImageLoaderUtils {

    private static ImageLoaderUtils mInstance;

    private ImageLoader mCoreImageLoader;

    private Context mContext;

    /**
     * 配置 ImageLoader
     */
    public void init() {
        if (mCoreImageLoader != null) {
            ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder
                    (mContext).denyCacheImageMultipleSizesInMemory()//拒绝多个尺寸的缓存
                    .threadPriority(Thread.NORM_PRIORITY - 2)//
                    .memoryCacheSize(2 * 1024 * 1024)//
                    .tasksProcessingOrder(QueueProcessingType.LIFO)//
                    .writeDebugLogs()//日志开关
                    .diskCacheFileNameGenerator(new Md5FileNameGenerator())//
                    .memoryCache(new WeakMemoryCache()).build();

            mCoreImageLoader.init(configuration);
        }
    }

    private ImageLoaderUtils(Context context) {
        mContext = context.getApplicationContext();
        mCoreImageLoader = ImageLoader.getInstance();
    }

    public static ImageLoaderUtils getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ImageLoaderUtils.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderUtils(context);
                }
            }
        }
        return mInstance;
    }

    public void displayImage(String uri, ImageView imageView) {
        displayImage(uri, imageView, null, null);
    }

    public void displayImage(String uri, ImageView imageView, OnImageLoadListener
            onImageLoadingListener) {
        displayImage(uri, imageView, null, onImageLoadingListener);
    }

    public void displayImage(String uri, ImageView imageView, DisplayOptions displayOptions) {
        displayImage(uri, imageView, displayOptions, null);
    }

    public void displayImage(final String uri, final ImageView imageView, DisplayOptions
            displayOptions, final OnImageLoadListener onImageLoadingListener) {
        DisplayImageOptions.Builder displayImageOptionsBuilder = new DisplayImageOptions.Builder();
        if (displayOptions != null) {
            displayImageOptionsBuilder.showImageForEmptyUri(displayOptions.getImageForEmptyUri
                    (mContext.getResources())).showImageOnFail(displayOptions.getImageOnFail
                    (mContext.getResources())).showImageOnLoading(displayOptions
                    .getImageOnLoading(mContext.getResources())).cacheInMemory(displayOptions
                    .isCacheInMemory()).cacheOnDisk(displayOptions.isCacheOnDisk()).build();
        }
        mCoreImageLoader.displayImage(uri, imageView, displayImageOptionsBuilder.build(), new
                ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (onImageLoadingListener != null) {
                    onImageLoadingListener.onImageLoadStart(imageUri, (ImageView) view);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (onImageLoadingListener != null) {
                    onImageLoadingListener.onImageLadFild();
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (onImageLoadingListener != null) {
                    onImageLoadingListener.onImageLoadComplete(uri, (ImageView) view, loadedImage);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                if (onImageLoadingListener != null) {
                    onImageLoadingListener.onImageLoadProgress(imageUri, (ImageView) view, total,
                            current);
                }
            }
        });
    }

}