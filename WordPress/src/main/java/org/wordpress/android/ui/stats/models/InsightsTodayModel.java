package org.wordpress.android.ui.stats.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.stores.model.SiteModel;

public class InsightsTodayModel extends BaseStatsModel {
    private String mDate;
    private String mPeriod;
    private int mVisitors;
    private int mViews;
    private int mLikes;
    private int mReblogs;
    private int mComments;
    private int mFollowers;

    public InsightsTodayModel(SiteModel site, JSONObject response) throws JSONException {
        super(site);
        this.mDate = response.getString("date");
        this.mPeriod = response.getString("period");
        this.mViews = response.optInt("views");
        this.mVisitors = response.optInt("visitors");
        this.mLikes = response.optInt("likes");
        this.mReblogs = response.optInt("reblogs");
        this.mComments = response.optInt("comments");
        this.mFollowers = response.optInt("followers");
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public int getReblogs() {
        return mReblogs;
    }

    public int getComments() {
        return mComments;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public int getLikes() {
        return mLikes;
    }

    public int getViews() {
        return mViews;
    }

    public int getVisitors() {
        return mVisitors;
    }
}
