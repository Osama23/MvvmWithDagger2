package com.osama.osama.mvvmdagger.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.osama.osama.mvvmdagger.data.ListItem;
import com.osama.osama.mvvmdagger.data.ListItemRepository;

public class ListItemViewModel extends ViewModel
{
    private ListItemRepository repository;

    ListItemViewModel(ListItemRepository repository)
    {
        this.repository = repository;
    }

    public LiveData<ListItem> getListItemById(String itemId)
    {
        return repository.getListItem(itemId);
    }
}
