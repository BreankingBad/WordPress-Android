package org.wordpress.android.ui.stats.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.stores.model.SiteModel;

public class InsightsLatestPostDetailsModel extends BaseStatsModel {
    private int mViews;

    public InsightsLatestPostDetailsModel(SiteModel site, JSONObject response) throws JSONException {
        super(site);
        this.mViews = response.getInt("views");
    }

    public int getPostViewsCount() {
        return mViews;
    }
}
