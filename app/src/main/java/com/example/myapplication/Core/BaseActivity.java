package com.example.myapplication.Core;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class BaseActivity extends AppCompatActivity {
    LottieDialogFragment lottieDialogFragment;
    public static String PREFERENCE_FILE_KEY="rasis";
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base));

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("font/iranyekanwebregular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());


    }
    public void showProgressDialog(){
        lottieDialogFragment=  new LottieDialogFragment().newInstance();
        lottieDialogFragment.show(getSupportFragmentManager(),"");
    }
    public void DimissProgressDialog(){
        lottieDialogFragment.dismiss();
    }

}
