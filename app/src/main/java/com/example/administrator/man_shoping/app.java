package com.example.administrator.man_shoping;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class app extends Application{
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=context;
        Fresco.initialize(this);
    }
}
