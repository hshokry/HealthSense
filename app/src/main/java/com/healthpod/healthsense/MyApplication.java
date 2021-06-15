package com.healthpod.healthsense;

import android.app.Application;

/**application class
 *
 * Created by jianddongguo on 2017/7/20.
 */

public class MyApplication extends Application {
    private CrashHandler mCrashHandler;
    // File Directory in sd card
    public static final String DIRECTORY_NAME = "USBCameraDataDirectory";

    @Override
    public void onCreate() {
        super.onCreate();
        mCrashHandler = CrashHandler.getInstance();
        mCrashHandler.init(getApplicationContext(), getClass());
    }
}