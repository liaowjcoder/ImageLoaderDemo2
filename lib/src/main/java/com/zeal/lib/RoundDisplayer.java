package com.zeal.lib;

import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/22 13:38
 * @描述 ${TODO}
 */
public class RoundDisplayer implements BitmapDisplayer {
    private RoundedBitmapDisplayer mDisplayer;

    public RoundDisplayer(int radius) {
        this.mDisplayer = new RoundedBitmapDisplayer(radius);
    }

    @Override
    public RoundedBitmapDisplayer getBitmapDisplayer() {
        return mDisplayer;
    }
}

