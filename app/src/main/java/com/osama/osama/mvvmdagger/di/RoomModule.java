package com.osama.osama.mvvmdagger.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.osama.osama.mvvmdagger.data.ListItemDao;
import com.osama.osama.mvvmdagger.data.ListItemDatabase;
import com.osama.osama.mvvmdagger.data.ListItemRepository;
import com.osama.osama.mvvmdagger.viewmodel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


// provide everything we might need to work with Room Database
@Module
public class RoomModule
{
    private final ListItemDatabase database;

    // create our database
    // pass the application parm because room database builder which we use to retrieve database reqire it
    public RoomModule(Application application) {
        this.database = Room.databaseBuilder(
                application,
                ListItemDatabase.class,
                "ListItem.db"
        ).build();
    }

    @Provides
    @Singleton
    ListItemRepository provideListItemRepository(ListItemDao listItemDao){
        return new ListItemRepository(listItemDao);
    }

    @Provides
    @Singleton
    ListItemDao provideListItemDao(ListItemDatabase database)
    {
        return database.listItemDao();
    }

    @Provides
    @Singleton
    ListItemDatabase provideListItemDatabase(Application application){
        return database;
    }


    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ListItemRepository repository){
        return new CustomViewModelFactory(repository);
    }
}
