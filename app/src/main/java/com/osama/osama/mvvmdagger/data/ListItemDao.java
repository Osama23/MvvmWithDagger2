package com.osama.osama.mvvmdagger.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.osama.osama.mvvmdagger.data.ListItem;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * A DAO, or Data Access Object, is a layer of abstraction (interface) between Java Objects and
 * SQL Statements.
 *
 * For a given entity, it defines how we may manage said entity within the Database.
 * Created by R_KAY on 7/31/2017.
 */
@Dao
public interface ListItemDao {

    /**
     * Get entity by itemId. For this App, we will pass in an ID when the detail Activity starts;
     * therefore we need not use LiveData as the Data will not change during the Activity's
     * Lifecycle.
     * @param itemId A Unique identifier for a given record within the Database.
     * @return
     */
    @Query("SELECT * FROM ListItem WHERE itemId = :itemId")
    LiveData<com.osama.osama.mvvmdagger.data.ListItem> getListItemById(String itemId);

    /**
     * Get all entities of type ListItem
     * @return
     */
    @Query("SELECT * FROM ListItem")
    LiveData<List<com.osama.osama.mvvmdagger.data.ListItem>> getListItems();

    /**
     * Insert a new ListItem
     * @param listItem
     * return the number of record you have inserted
     */
    @Insert(onConflict = REPLACE)
    Long insertListItem(com.osama.osama.mvvmdagger.data.ListItem listItem);

    /**
     * Delete a given ListItem
     * @param listItem
     */
    @Delete
    void deleteListItem(com.osama.osama.mvvmdagger.data.ListItem listItem);

}
