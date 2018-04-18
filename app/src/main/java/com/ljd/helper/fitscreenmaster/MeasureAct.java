package com.ljd.helper.fitscreenmaster;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljd.helper.fitscreenlib.UtilScreen;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/18
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class MeasureAct extends Activity {
    TextView tv_1, tv_2, tv_3;
    Context context=MeasureAct.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_measure);
        MyApplication.scaleScreenHelper.loadView((ViewGroup) getWindow().getDecorView());
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("宽度", "onCreate: px宽度" + width(tv_1));

        Log.d("宽度", UtilScreen.pxToTag(context,0,750)+"onCreate: px转换Tag" + UtilScreen.pxToTag(context,width(tv_1),750));

        Log.d("宽度",  UtilScreen.tagToPx(context,0,750)+"onCreate: Tag转换成px" + UtilScreen.tagToPx(context,200,750));

    }


    private int width(View view) {
        return view.getWidth();
    }




}
