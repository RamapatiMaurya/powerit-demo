package com.powerit.mvvmdemo.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.powerit.mvvmdemo.R;
import com.powerit.mvvmdemo.model.Blog;
import com.powerit.mvvmdemo.model.CanadaBlog;
import com.powerit.mvvmdemo.service.Utility;
import com.powerit.mvvmdemo.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    private ActionBar mActionBar;

    CanadaBlogAdapter mCanadaBlogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationViews();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPopularBlog();
        // lambda expression
        swipeRefresh.setOnRefreshListener(this::getPopularBlog);
    }

    private void initializationViews() {
        mActionBar = getSupportActionBar();
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }

    public void getPopularBlog() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllBlog().observe(this, new Observer<List<CanadaBlog>>() {
            @Override
            public void onChanged(@Nullable List<CanadaBlog> blogList) {
                swipeRefresh.setRefreshing(false);
                String title = Utility.getStringPreference(MainActivity.this, "Title");
                if(title!=null)
                mActionBar.setTitle(title);
                prepareRecyclerView(blogList);
            }
        });

    }

    private void prepareRecyclerView(List<CanadaBlog> blogList) {

        mCanadaBlogAdapter = new CanadaBlogAdapter(blogList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mCanadaBlogAdapter);
        mCanadaBlogAdapter.notifyDataSetChanged();

    }

}
