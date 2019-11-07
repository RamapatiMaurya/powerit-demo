package com.powerit.mvvmdemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.powerit.mvvmdemo.model.Blog;
import com.powerit.mvvmdemo.model.CanadaBlog;
import com.powerit.mvvmdemo.model.CanadaBlogRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CanadaBlogRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new CanadaBlogRepository(application);
    }

    public LiveData<List<CanadaBlog>> getAllBlog() {
        return movieRepository.getMutableLiveData();
    }



}
