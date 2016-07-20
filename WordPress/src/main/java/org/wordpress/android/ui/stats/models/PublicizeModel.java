package org.wordpress.android.ui.stats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.stores.model.SiteModel;

import java.util.ArrayList;
import java.util.List;

public class PublicizeModel extends BaseStatsModel {
    private List<SingleItemModel> mServices;

    public PublicizeModel(SiteModel site, JSONObject response) throws JSONException {
        super(site);
        JSONArray services = response.getJSONArray("services");
        if (services.length() > 0) {
            mServices = new ArrayList<>(services.length());
            for (int i = 0; i < services.length(); i++) {
                JSONObject current = services.getJSONObject(i);
                String serviceName = current.getString("service");
                int followers = current.getInt("followers");
                SingleItemModel currentItem = new SingleItemModel(site, null, null, serviceName, followers, null, null);
                mServices.add(currentItem);
            }
        }
    }

    public List<SingleItemModel> getServices() {
        return mServices;
    }
}
