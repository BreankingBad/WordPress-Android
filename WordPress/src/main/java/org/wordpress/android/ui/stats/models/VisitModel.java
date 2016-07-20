package org.wordpress.android.ui.stats.models;

import org.wordpress.android.stores.model.SiteModel;

import java.io.Serializable;

public class VisitModel implements Serializable {
    private int mViews;
    private int mLikes;
    private int mVisitors;
    private int mComments;
    private String mPeriod;
    private SiteModel mSite;

    public int getViews() {
        return mViews;
    }

    public void setViews(int views) {
        this.mViews = views;
    }

    public int getLikes() {
        return mLikes;
    }

    public void setLikes(int likes) {
        this.mLikes = likes;
    }

    public int getVisitors() {
        return mVisitors;
    }

    public void setVisitors(int visitors) {
        this.mVisitors = visitors;
    }

    public int getComments() {
        return mComments;
    }

    public void setComments(int comments) {
        this.mComments = comments;
    }

    public String getPeriod() {
        return mPeriod;
    }

    public void setPeriod(String period) {
        this.mPeriod = period;
    }

    public SiteModel getSite() {
        return mSite;
    }

    public void setSite(SiteModel site) {
        mSite = site;
    }
}
