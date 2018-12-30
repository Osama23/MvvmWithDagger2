package com.osama.osama.mvvmdagger;

import android.app.Application;

import com.osama.osama.mvvmdagger.di.ApplicationComponent;
import com.osama.osama.mvvmdagger.di.ApplicationModule;
import com.osama.osama.mvvmdagger.di.DaggerApplicationComponent;
import com.osama.osama.mvvmdagger.di.RoomModule;

public class RoomDemoApplication extends Application
{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
