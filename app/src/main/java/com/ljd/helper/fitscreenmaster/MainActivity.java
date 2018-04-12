package com.ljd.helper.fitscreenmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.ljd.helper.fitscreenlib.ScaleScreenHelper;
import com.ljd.helper.fitscreenlib.ScaleScreenHelperFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.scaleScreenHelper.loadView((ViewGroup) getWindow().getDecorView());



    }
}
