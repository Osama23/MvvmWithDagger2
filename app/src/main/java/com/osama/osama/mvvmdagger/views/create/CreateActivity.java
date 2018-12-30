package com.osama.osama.mvvmdagger.views.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.osama.osama.mvvmdagger.R;
import com.osama.osama.mvvmdagger.views.base.BaseActivity;


public class CreateActivity extends BaseActivity
{
    // create the tag for our ListFragment
    private static final String CREATE_FRAG = "CREATE_FRAG";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        // put the fragment
        FragmentManager manager = getSupportFragmentManager();
        CreateFragment fragment = (CreateFragment) manager.findFragmentByTag(CREATE_FRAG);

        if (fragment == null)
        {
            // we need to set it
            fragment = CreateFragment.newInstance();
        }

        addFragmentToActivity(manager,fragment,R.id.root_activity_create,CREATE_FRAG);
    }
}
