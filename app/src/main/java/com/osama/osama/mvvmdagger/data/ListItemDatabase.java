package com.osama.osama.mvvmdagger.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.osama.osama.mvvmdagger.data.ListItem;
import com.osama.osama.mvvmdagger.data.ListItemDao;


@Database(entities = {ListItem.class}, version = 1)
public abstract class ListItemDatabase extends RoomDatabase
{
    // provide a way with which we can use our database throw the DAO
    public abstract ListItemDao listItemDao();
}
