package com.zeal.lib;

import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/22 12:17
 * @描述 ${TODO} 
 */

public class CircleDisplayer implements BitmapDisplayer {

    private CircleBitmapDisplayer mDisplayer;

    public CircleDisplayer() {
        this.mDisplayer = new CircleBitmapDisplayer();
    }

    public CircleDisplayer(int strokeColor, int strokeWidth) {
        this.mDisplayer = new CircleBitmapDisplayer(strokeColor, strokeWidth);
    }

    public CircleDisplayer(int strokeColor) {
        this.mDisplayer = new CircleBitmapDisplayer(strokeColor, 0);
    }

    @Override
    public CircleBitmapDisplayer getBitmapDisplayer() {
        return mDisplayer;
    }
}
