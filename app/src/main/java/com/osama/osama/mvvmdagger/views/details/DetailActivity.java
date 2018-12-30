package com.osama.osama.mvvmdagger.views.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.osama.osama.mvvmdagger.R;
import com.osama.osama.mvvmdagger.views.base.BaseActivity;

public class DetailActivity extends BaseActivity
{
    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    // create the tag for our ListFragment
    private static final String DETAIL_FRAG = "DETAIL_FRAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent i = getIntent();

        //if extra is null, not worth even bothering to set up the MVVM stuff; Kill it with fire.
        if (i.hasExtra(EXTRA_ITEM_ID))
        {
            String itemId = i.getStringExtra(EXTRA_ITEM_ID);
        // put the fragment
            FragmentManager manager = getSupportFragmentManager();
            DetailFragment fragment = (DetailFragment) manager.findFragmentByTag(DETAIL_FRAG);

            if (fragment == null)
            {
                 // we need to set it
                 fragment = DetailFragment.newInstance(itemId);
            }

            addFragmentToActivity(manager,fragment,R.id.root_activity_detail,DETAIL_FRAG);
        }
        else
        {
            Toast.makeText(this, R.string.error_no_extra_found, Toast.LENGTH_LONG).show();
        }
    }
}
