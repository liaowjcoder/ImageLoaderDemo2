package com.zeal.lib;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/22 10:15
 * @描述 图片加载监听器
 */

public interface OnImageLoadListener {

    void onImageLoadStart(String uri, ImageView imageView);

    void onImageLoadComplete(String uri, ImageView imageView, Bitmap bitmap);

    void onImageLadFild();

    void onImageLoadProgress(String uri, ImageView view,long total, long current);

}
