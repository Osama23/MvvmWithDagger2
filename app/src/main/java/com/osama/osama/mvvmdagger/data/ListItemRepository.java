package com.osama.osama.mvvmdagger.data;

import android.arch.lifecycle.LiveData;

import com.osama.osama.mvvmdagger.data.ListItem;
import com.osama.osama.mvvmdagger.data.ListItemDao;

import java.util.List;

import javax.inject.Inject;

public class ListItemRepository
{
    private final com.osama.osama.mvvmdagger.data.ListItemDao listItemDao;

    @Inject
    public ListItemRepository(com.osama.osama.mvvmdagger.data.ListItemDao listItemDao){
        this.listItemDao = listItemDao;
    }

    public LiveData<List<com.osama.osama.mvvmdagger.data.ListItem>> getListOfData()
    {
        return listItemDao.getListItems();
    }

    public LiveData<com.osama.osama.mvvmdagger.data.ListItem> getListItem(String itemId)
    {
        return listItemDao.getListItemById(itemId);
    }

    public Long createNewListItem(com.osama.osama.mvvmdagger.data.ListItem listItem)
    {
        return listItemDao.insertListItem(listItem);
    }

    public void deleteListItem(com.osama.osama.mvvmdagger.data.ListItem listItem)
    {
        listItemDao.deleteListItem(listItem);
    }

}
