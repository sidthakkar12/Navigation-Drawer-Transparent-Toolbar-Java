package com.app.navigationdrawersample.utils;

import android.app.Application;

public class AppController extends Application {

    private static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;
    private static RxBus mRxBus;

    public static RxBus getmRxBus() {
        return mRxBus;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        mRxBus = new RxBus();
    }
}