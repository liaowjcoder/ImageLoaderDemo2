package com.zeal.imageloaderdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

public class MainActivity extends BaseActivity {

    private ImageView image;
    private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        image2 = (ImageView) findViewById(R.id.image2);


        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).build();

        mImageLoader.displayImage("http://pic1.win4000.com/wallpaper/4/51f9cae59e5db" +
                ".jpg", image, options, null, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                Log.e("zeal", "--------current:" + current + ";total:" + total);
            }
        });
        mImageLoader.displayImage("http://p5.image.hiapk.com/uploads/allimg/141018/1621411c9-3.png", image2, options, null, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                Log.e("zeal", "--------current:" + current + ";total:" + total);
            }
        });
    }
}
