package com.example.work.searchimages.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imageobject {

    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("contenturl")
    @Expose
    private String contenturl;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getContenturl() {
        return contenturl;
    }

    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

}