package org.wordpress.android.ui.stats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.stores.model.SiteModel;
import org.wordpress.android.util.AppLog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReferrersModel extends BaseStatsModel {
    private String mPeriod;
    private String mDate;
    private int mOtherViews;
    private int mTotalViews;
    private List<ReferrerGroupModel> mGroups;

    public ReferrersModel(SiteModel site, JSONObject response) throws JSONException {
        super(site);
        this.mPeriod = response.getString("period");
        this.mDate = response.getString("date");

        JSONObject jDaysObject = response.getJSONObject("days");
        if (jDaysObject.length() == 0) {
            throw new JSONException("Invalid document returned from the REST API");
        }

        JSONArray jGroupsArray;
        // Read the first day
        Iterator<String> keys = jDaysObject.keys();
        String key = keys.next();
        JSONObject firstDayObject = jDaysObject.getJSONObject(key);
        this.mOtherViews = firstDayObject.optInt("other_views");
        this.mTotalViews = firstDayObject.optInt("total_views");
        jGroupsArray = firstDayObject.optJSONArray("groups");

        if (jGroupsArray != null) {
            mGroups = new ArrayList<>(jGroupsArray.length());
            for (int i = 0; i < jGroupsArray.length(); i++) {
                try {
                    JSONObject currentGroupJSON = jGroupsArray.getJSONObject(i);
                    ReferrerGroupModel currentGroupModel = new ReferrerGroupModel(site, mDate, currentGroupJSON);
                    mGroups.add(currentGroupModel);
                } catch (JSONException e) {
                    AppLog.e(AppLog.T.STATS, "Unexpected ReferrerGroupModel object " +
                            "at position " + i + " Response: " + response.toString(), e);
                }
            }
        }
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getPeriod() {
        return mPeriod;
    }

    public void setPeriod(String period) {
        this.mPeriod = period;
    }

    public List<ReferrerGroupModel> getGroups() {
        return this.mGroups;
    }

    public int getOtherViews() {
        return mOtherViews;
    }

    public int getTotalViews() {
        return mTotalViews;
    }
}
