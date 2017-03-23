package com.zeal.lib;

import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

/**
 * @作者 廖伟健
 * @创建时间 2017/3/22 18:26
 * @描述 ${TODO} 
 */

public class NormalDisplayer implements BitmapDisplayer {
    private SimpleBitmapDisplayer mDisplayer;

    public NormalDisplayer() {
        mDisplayer = new SimpleBitmapDisplayer();
    }

    @Override
    public Object getBitmapDisplayer() {
        return mDisplayer;
    }
}
