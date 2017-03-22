package com.zeal.imageloaderdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/20 15:45
 * @描述 ${TODO} 
 */

public class BaseActivity extends AppCompatActivity {
    protected ImageLoader mImageLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImageLoader = ImageLoader.getInstance();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImageLoader.clearMemoryCache();
    }
}
