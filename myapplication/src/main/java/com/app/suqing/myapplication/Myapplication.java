package com.app.suqing.myapplication;

import android.app.Application;

import net.nashlegend.anypref.AnyPref;

/**
 * Created by hellohome on 2016/11/18.
 */

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AnyPref.init(this);
    }
}
