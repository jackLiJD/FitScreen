package com.ljd.helper.fitscreenlib;

import android.content.Context;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/12
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class ScaleScreen {
    int SCREEN_WIDTH;
    int SCREEN_HIGHT;

    public ScaleScreen(Context context) {
            int[] size = UtilScreen.screenSize(context);
            this.SCREEN_WIDTH = size[0];
            this.SCREEN_HIGHT = size[1];

    }
}
