package com.hulian.illegalsystem.app;

import android.app.Application;
import android.content.Context;

/**
 * 作者：qgl 时间： 2020/9/18 09:27
 * Describe:
 */
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
