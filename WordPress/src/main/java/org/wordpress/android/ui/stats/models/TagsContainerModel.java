package org.wordpress.android.ui.stats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.stores.model.SiteModel;

import java.util.ArrayList;
import java.util.List;

public class TagsContainerModel extends BaseStatsModel {
    private String mDate;
    private List<TagsModel> mTags;

    public TagsContainerModel(SiteModel site, JSONObject response) throws JSONException {
        super(site);
        this.mDate = response.getString("date");
        JSONArray outerTags = response.getJSONArray("tags");
        if (outerTags != null) {
             mTags = new ArrayList<>(outerTags.length());
            for (int i = 0; i < outerTags.length(); i++) {
                JSONObject current = outerTags.getJSONObject(i);
                mTags.add(new TagsModel(current));
            }
        }
    }

    public List<TagsModel> getTags() {
        return mTags;
    }

    public String getDate() {
        return mDate;
    }
}
