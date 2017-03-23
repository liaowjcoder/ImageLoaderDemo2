package com.zeal.lib;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/22 10:20
 * @描述 显示配置
 */

public class DisplayOptions {
    private final int imageResOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;

    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;

    private BitmapDisplayer displayer;

    private DisplayOptions(Builder builder) {
        imageResOnLoading = builder.imageResOnLoading;
        imageResForEmptyUri = builder.imageResForEmptyUri;
        imageResOnFail = builder.imageResOnFail;
        cacheInMemory = builder.cacheInMemory;
        cacheOnDisk = builder.cacheOnDisk;
        displayer = builder.displayer;
    }

    public void setDisplayer(BitmapDisplayer displayer) {
        this.displayer = displayer;
    }

    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;

        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;

        private BitmapDisplayer displayer = null;


        public Builder showImageOnLoading(int imageRes) {
            imageResOnLoading = imageRes;
            return this;
        }


        public Builder showImageForEmptyUri(int imageRes) {
            imageResForEmptyUri = imageRes;
            return this;
        }

        public Builder showImageOnFail(int imageRes) {
            imageResOnFail = imageRes;
            return this;
        }

        public Builder cacheInMemory(boolean cacheInMemory) {
            this.cacheInMemory = cacheInMemory;
            return this;
        }

        public Builder cacheOnDisk(boolean cacheOnDisk) {
            this.cacheOnDisk = cacheOnDisk;
            return this;
        }

        public Builder setDisplayer(BitmapDisplayer displayer) {
            this.displayer = displayer;
            return this;
        }

        public DisplayOptions build() {
            return new DisplayOptions(this);
        }


    }


    public Drawable getImageOnLoading(Resources res) {
        return imageResOnLoading != 0 ? res.getDrawable(imageResOnLoading) : null;
    }

    public Drawable getImageForEmptyUri(Resources res) {
        return imageResForEmptyUri != 0 ? res.getDrawable(imageResForEmptyUri) : null;
    }

    public Drawable getImageOnFail(Resources res) {
        return imageResOnFail != 0 ? res.getDrawable(imageResOnFail) : null;
    }

    public boolean isCacheInMemory() {
        return cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return cacheOnDisk;
    }

    public BitmapDisplayer getDisplayer() {
        return displayer;
    }

}
