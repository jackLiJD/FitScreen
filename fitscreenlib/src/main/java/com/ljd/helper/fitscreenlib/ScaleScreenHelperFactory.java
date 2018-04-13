package com.ljd.helper.fitscreenlib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/12
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public final class ScaleScreenHelperFactory extends ScaleScreen implements ScaleScreenHelper {
    private int scaleWidth;
    private float scaleSize;

    private ScaleScreenHelperFactory(Context context, int scaleWidth) {
        this(context, scaleWidth, 1.0F);
    }

    private ScaleScreenHelperFactory(Context context, int scaleWidth, float scaleSize) {
        super(context);
        this.scaleWidth = scaleWidth;
        this.scaleSize = scaleSize;
    }

    public View loadViewPadding(View view, int left, int top, int right, int bottom) {
        try {
            view.setPadding(this.getWidthHeight(left), this.getWidthHeight(top), this.getWidthHeight(right), this.getWidthHeight(bottom));
        } catch (Exception var7) {
            ;
        }

        return view;
    }

    public View loadViewMinMax(View v, int nw, int nh, int xw, int xh) {
        try {
            if(nw != 0) {
                v.getClass().getMethod("setMinWidth", new Class[]{Integer.TYPE}).invoke(v, new Object[]{Integer.valueOf(this.getWidthHeight(nw))});
            }

            if(nh != 0) {
                v.getClass().getMethod("setMinHeight", new Class[]{Integer.TYPE}).invoke(v, new Object[]{Integer.valueOf(this.getWidthHeight(nw))});
            }

            if(xw != 0) {
                v.getClass().getMethod("setMaxWidth", new Class[]{Integer.TYPE}).invoke(v, new Object[]{Integer.valueOf(this.getWidthHeight(nw))});
            }

            if(xh != 0) {
                v.getClass().getMethod("setMaxHeight", new Class[]{Integer.TYPE}).invoke(v, new Object[]{Integer.valueOf(this.getWidthHeight(nw))});
            }
        } catch (Exception var7) {
            ;
        }

        return v;
    }


    public View loadViewMargin(View view, int left, int top, int right, int bottom) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
            marginLayoutParams.leftMargin = this.getWidthHeight(left);
            marginLayoutParams.topMargin = this.getWidthHeight(top);
            marginLayoutParams.rightMargin = this.getWidthHeight(right);
            marginLayoutParams.bottomMargin = this.getWidthHeight(bottom);
        } catch (Exception var7) {
            ;
        }

        return view;
    }

    public View loadViewWidthHeightSize(View view, int width, int height, int size) {
        return this.loadViewSize(this.loadViewWidthHeight(view, width, height), size);
    }

    public View loadViewWidthHeight(View view, int width, int height) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
            int paramsWidth = this.getWidthHeight(width);
            int paramsHeight = this.getWidthHeight(height);
            if(paramsWidth != 0) {
                marginLayoutParams.width = paramsWidth;
            }

            if(paramsHeight != 0) {
                marginLayoutParams.height = paramsHeight;
            }
        } catch (Exception var7) {
            ;
        }

        return view;
    }

    public View loadViewSize(View view, int size) {
        if(view instanceof TextView) {
            ((TextView)view).setTextSize(0, this.getSize(size));
        } else if(view instanceof EditText) {
            ((EditText)view).setTextSize(0, this.getSize(size));
        } else if(view instanceof Button) {
            ((Button)view).setTextSize(0, this.getSize(size));
        } else if(view instanceof CheckBox) {
            ((CheckBox)view).setTextSize(0, this.getSize(size));
        } else if(view instanceof RadioButton) {
            ((RadioButton)view).setTextSize(0, this.getSize(size));
        }

        return view;
    }

    public View loadView(ViewGroup viewGroup, ScaleBox scaleBox) {
        scaleBox.onScale(this.tagEmpty(viewGroup.getTag()), viewGroup, this);

        for(int i = 0; i < viewGroup.getChildCount(); ++i) {
            View view = viewGroup.getChildAt(i);
            if(view instanceof ViewGroup) {
                this.loadView((ViewGroup)view, scaleBox);
            } else {
                scaleBox.onScale(this.tagEmpty(view.getTag()), view, this);
            }
        }

        return viewGroup;
    }

    public View loadView(ViewGroup viewGroup) {
        return this.loadView(viewGroup, new ScaleBox());
    }

    public int getWidthHeight(int value) {
        return (int)this.scaleValue((float)this.SCREEN_WIDTH, (float)this.scaleWidth, (float)value);
    }

    public float getSize(int value) {
        return this.scaleValue((float)this.SCREEN_WIDTH, (float)this.scaleWidth, (float)value) * this.scaleSize;
    }

    private float scaleValue(float value1, float value2, float value3) {
        return value2 > value3?value1 / (value2 / value3):value1 * (value3 / value2);
    }

    private String tagEmpty(Object object) {
        try {
            return object.toString();
        } catch (Exception var3) {
            return "";
        }
    }

    public static ScaleScreenHelper create(Context context, int scaleWidth) {
        return new ScaleScreenHelperFactory(context, scaleWidth);
    }

    public static ScaleScreenHelper create(Context context, int scaleWidth, float scaleSize) {
        return new ScaleScreenHelperFactory(context, scaleWidth, scaleSize);
    }
}
