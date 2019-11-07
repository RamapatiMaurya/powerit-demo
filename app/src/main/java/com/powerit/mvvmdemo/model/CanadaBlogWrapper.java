package com.powerit.mvvmdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class CanadaBlogWrapper {

    @SerializedName("rows")
    private List<CanadaBlog> mCanadaData;
    @SerializedName("title")
    private String mTitle;

    public List<CanadaBlog> getmCanadaData() {
        return mCanadaData;
    }

    public void setmCanadaData(List<CanadaBlog> mCanadaData) {
        this.mCanadaData = mCanadaData;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
