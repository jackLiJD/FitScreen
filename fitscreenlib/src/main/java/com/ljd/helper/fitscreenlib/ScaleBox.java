package com.ljd.helper.fitscreenlib;

import android.view.View;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/4/12
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class ScaleBox {
    private String[] temp;

    public ScaleBox() {
    }

    public void onScale(String tag, View view, ScaleScreenHelperFactory helper) {
        if(tag != null && !tag.equals("")) {
            if((this.temp = this.getValues(tag, "(", ")")) != null) {
                try {
                    if(this.temp.length == 3) {
                        helper.loadViewWidthHeightSize(view, Integer.parseInt(this.temp[0]), Integer.parseInt(this.temp[1]), Integer.parseInt(this.temp[2]));
                    } else if(this.temp.length == 2) {
                        helper.loadViewWidthHeight(view, Integer.parseInt(this.temp[0]), Integer.parseInt(this.temp[1]));
                    } else {
                        helper.loadViewSize(view, Integer.parseInt(this.temp[0]));
                    }
                } catch (Exception var7) {
                    ;
                }
            }

            if((this.temp = this.getValues(tag, "[", "]")) != null) {
                try {
                    helper.loadViewPadding(view, Integer.parseInt(this.temp[0]), Integer.parseInt(this.temp[1]), Integer.parseInt(this.temp[2]), Integer.parseInt(this.temp[3]));
                } catch (Exception var6) {
                    ;
                }
            }

            if((this.temp = this.getValues(tag, "{", "}")) != null) {
                try {
                    helper.loadViewMargin(view, Integer.parseInt(this.temp[0]), Integer.parseInt(this.temp[1]), Integer.parseInt(this.temp[2]), Integer.parseInt(this.temp[3]));
                } catch (Exception var5) {
                    ;
                }
            }
        }

    }

    private String[] getValues(String tag, String start, String end) {
        return tag.contains(start) && tag.contains(end)?tag.substring(tag.indexOf(start) + 1, tag.indexOf(end)).split(","):null;
    }
}
