package com.osama.osama.mvvmdagger.views.list;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.osama.osama.mvvmdagger.R;
import com.osama.osama.mvvmdagger.views.base.BaseActivity;

public class ListActivity extends BaseActivity
{
    // create the tag for our ListFragment
    private static final String LIST_FRAG = "LIST_FRAG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // put the fragment
        FragmentManager manager = getSupportFragmentManager();
        ListFragment listFragment = (ListFragment) manager.findFragmentByTag(LIST_FRAG);
        if (listFragment == null)
        {
            // we need to set it
            listFragment = ListFragment.newInstance();
        }

        addFragmentToActivity(manager,listFragment,R.id.root_activity_list,LIST_FRAG);
    }
}
