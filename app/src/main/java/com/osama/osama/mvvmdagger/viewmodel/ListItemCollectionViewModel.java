package com.osama.osama.mvvmdagger.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.osama.osama.mvvmdagger.data.ListItem;
import com.osama.osama.mvvmdagger.data.ListItemRepository;

import java.util.List;

public class ListItemCollectionViewModel extends ViewModel
{
    private ListItemRepository repository;

    ListItemCollectionViewModel(ListItemRepository repository)
    {
        this.repository = repository;
    }

    public LiveData<List<ListItem>> getListItems() {
        return repository.getListOfData();
    }

    public void deleteListItem(ListItem listItem)
    {
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(listItem);
    }

    private class DeleteItemTask extends AsyncTask<ListItem, Void, Void>
    {
        @Override
        protected Void doInBackground(ListItem... item)
        {
            repository.deleteListItem(item[0]);
            return null;
        }
    }

}
