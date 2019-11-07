package com.powerit.mvvmdemo.service;

import com.powerit.mvvmdemo.model.CanadaBlogWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {


    @GET("facts.json")
    Call<CanadaBlogWrapper> getPopularBlog();

}
