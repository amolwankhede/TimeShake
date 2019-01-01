package com.speechry.timeshake;



import android.app.Application;
import com.facebook.stetho.Stetho;

//Class purely implemented for Stetho lib to see the data in chrome://inspect

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
