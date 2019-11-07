package com.powerit.mvvmdemo.model;

import com.google.gson.annotations.SerializedName;

public class CanadaBlog {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("imageHref")
    private String mLink;
    @SerializedName("title")
    private String mTitle;

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

}
