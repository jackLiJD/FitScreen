package com.ljd.helper.fitscreenlib;

import android.view.View;
import android.view.ViewGroup;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/12
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public interface ScaleScreenHelper {
    View loadViewPadding(View var1, int var2, int var3, int var4, int var5);

    View loadViewMargin(View var1, int var2, int var3, int var4, int var5);

    View loadViewWidthHeightSize(View var1, int var2, int var3, int var4);

    View loadViewWidthHeight(View var1, int var2, int var3);

    View loadViewSize(View var1, int var2);

    View loadView(ViewGroup var1, ScaleBox var2);

    View loadView(ViewGroup var1);

    int getWidthHeight(int var1);

    float getSize(int var1);
}
