package com.osama.osama.mvvmdagger.di;

import android.app.Application;

import com.osama.osama.mvvmdagger.di.ApplicationModule;
import com.osama.osama.mvvmdagger.di.RoomModule;
import com.osama.osama.mvvmdagger.views.create.CreateFragment;
import com.osama.osama.mvvmdagger.views.details.DetailFragment;
import com.osama.osama.mvvmdagger.views.list.ListFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent
{
    void inject(ListFragment listFragment);
    void inject(CreateFragment createFragment);
    void inject(DetailFragment detailFragment);

    Application application();
}
