package com.ljd.helper.fitscreenlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/12
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class UtilScreen {
    private UtilScreen() {
    }

    public static int[] screenSize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }
    public static int pxToTag(Context context,int pxWidth,int sample ) {
        int tagWidth = 0;
        tagWidth = (pxWidth* sample / UtilScreen.screenSize(context)[0]) ;
        return tagWidth;
    }

    public static int tagToPx(Context context,int tagWidth,int sample){
        int pxWidth = 0;
        pxWidth = (tagWidth* UtilScreen.screenSize(context)[0]/sample ) ;
        return pxWidth;
    }
}
