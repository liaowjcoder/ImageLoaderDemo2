package com.zeal.imageloaderdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.zeal.lib.DisplayOptions;
import com.zeal.lib.ImageLoaderUtils;
import com.zeal.lib.OnImageLoadListener;

public class MainActivity extends BaseActivity {

    private ImageView image;
    private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        image2 = (ImageView) findViewById(R.id.image2);


        //        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory
        // (true)
        //                .cacheOnDisk(true).build();
        //
        //        mImageLoader.displayImage("http://pic1.win4000.com/wallpaper/4/51f9cae59e5db" +
        //                ".jpg", image, options, null, new ImageLoadingProgressListener() {
        //            @Override
        //            public void onProgressUpdate(String imageUri, View view, int current, int
        // total) {
        //                Log.e("zeal", "--------current:" + current + ";total:" + total);
        //            }
        //        });
        //        mImageLoader.displayImage("http://p5.image.hiapk
        // .com/uploads/allimg/141018/1621411c9-3.png", image2, options, null, new
        // ImageLoadingProgressListener() {
        //            @Override
        //            public void onProgressUpdate(String imageUri, View view, int current, int
        // total) {
        //                Log.e("zeal", "--------current:" + current + ";total:" + total);
        //            }
        //        });

        //自己封装
        DisplayOptions displayOptions = new DisplayOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).showImageOnLoading(R.mipmap.icon_job_post_straight)
                .showImageOnFail(R.mipmap.icon_height_light).showImageForEmptyUri(R.mipmap
                        .company_login_person).build();
        ImageLoaderUtils.getInstance(this).displayImage("http://pic1.win4000" +
                ".com/wallpaper/4/51f9cae59e5db.jpg", image, displayOptions, new
                OnImageLoadListener() {
            @Override
            public void onImageLoadStart(String uri, ImageView imageView) {
                Log.e("zeal", "onImageLoadStart");
            }

            @Override
            public void onImageLoadComplete(String uri, ImageView imageView, Bitmap bitmap) {
                Log.e("zeal", "onImageLoadComplete:" + bitmap.getByteCount() * bitmap.getRowBytes
                        ());
            }

            @Override
            public void onImageLadFild() {
                Log.e("zeal", "onImageLadFild");
            }

            @Override
            public void onImageLoadProgress(String uri, ImageView view, long total, long current) {
                Log.e("zeal", "total:" + total + ";current:" + current);
            }
        });

    }
}
