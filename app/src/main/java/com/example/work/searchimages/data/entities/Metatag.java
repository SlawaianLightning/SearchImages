package com.example.work.searchimages.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metatag {

    @SerializedName("theme-color")
    @Expose
    private String themeColor;
    @SerializedName("viewport")
    @Expose
    private String viewport;
    @SerializedName("og:image")
    @Expose
    private String ogImage;
    @SerializedName("og:type")
    @Expose
    private String ogType;
    @SerializedName("og:title")
    @Expose
    private String ogTitle;
    @SerializedName("twitter:card")
    @Expose
    private String twitterCard;
    @SerializedName("twitter:site")
    @Expose
    private String twitterSite;
    @SerializedName("twitter:title")
    @Expose
    private String twitterTitle;
    @SerializedName("twitter:image")
    @Expose
    private String twitterImage;
    @SerializedName("twitter:image:width")
    @Expose
    private String twitterImageWidth;
    @SerializedName("twitter:image:height")
    @Expose
    private String twitterImageHeight;

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public String getViewport() {
        return viewport;
    }

    public void setViewport(String viewport) {
        this.viewport = viewport;
    }

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getOgType() {
        return ogType;
    }

    public void setOgType(String ogType) {
        this.ogType = ogType;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public String getTwitterCard() {
        return twitterCard;
    }

    public void setTwitterCard(String twitterCard) {
        this.twitterCard = twitterCard;
    }

    public String getTwitterSite() {
        return twitterSite;
    }

    public void setTwitterSite(String twitterSite) {
        this.twitterSite = twitterSite;
    }

    public String getTwitterTitle() {
        return twitterTitle;
    }

    public void setTwitterTitle(String twitterTitle) {
        this.twitterTitle = twitterTitle;
    }

    public String getTwitterImage() {
        return twitterImage;
    }

    public void setTwitterImage(String twitterImage) {
        this.twitterImage = twitterImage;
    }

    public String getTwitterImageWidth() {
        return twitterImageWidth;
    }

    public void setTwitterImageWidth(String twitterImageWidth) {
        this.twitterImageWidth = twitterImageWidth;
    }

    public String getTwitterImageHeight() {
        return twitterImageHeight;
    }

    public void setTwitterImageHeight(String twitterImageHeight) {
        this.twitterImageHeight = twitterImageHeight;
    }

}