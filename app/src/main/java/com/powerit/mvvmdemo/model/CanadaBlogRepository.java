package com.powerit.mvvmdemo.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.SharedPreferences;

import com.powerit.mvvmdemo.service.RestApiService;
import com.powerit.mvvmdemo.service.RetrofitInstance;
import com.powerit.mvvmdemo.service.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CanadaBlogRepository {
    private ArrayList<CanadaBlog> blogs = new ArrayList<>();
    private MutableLiveData<List<CanadaBlog>> mutableLiveData = new MutableLiveData<>();
    private String title;
    private Application application;

    public CanadaBlogRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<CanadaBlog>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<CanadaBlogWrapper> call = apiService.getPopularBlog();

        call.enqueue(new Callback<CanadaBlogWrapper>() {
            @Override
            public void onResponse(Call<CanadaBlogWrapper> call, Response<CanadaBlogWrapper> response) {
                CanadaBlogWrapper mBlogWrapper = response.body();
                if (mBlogWrapper != null && mBlogWrapper.getmTitle() != null) {
                    blogs = (ArrayList<CanadaBlog>) mBlogWrapper.getmCanadaData();
                    mutableLiveData.setValue(blogs);

                    Utility.saveStringPreference(application, "Title", mBlogWrapper.getmTitle());
                }
            }

            @Override
            public void onFailure(Call<CanadaBlogWrapper> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }

}
