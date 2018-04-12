package com.ljd.helper.fitscreenmaster;

import android.app.Application;
import android.content.Intent;
import android.os.StrictMode;

import com.ljd.helper.fitscreenlib.ScaleScreenHelper;
import com.ljd.helper.fitscreenlib.ScaleScreenHelperFactory;

import java.io.File;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/12
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class MyApplication extends Application {
    public static ScaleScreenHelper scaleScreenHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        scaleScreenHelper = ScaleScreenHelperFactory.create(this, 750);
    }
}