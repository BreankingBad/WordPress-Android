package org.wordpress.android.ui.stats.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.stores.model.SiteModel;

import java.util.ArrayList;
import java.util.List;


public class CommentFollowersModel extends BaseStatsModel {
    private int mPage;
    private int mPages;
    private int mTotal;
    private List<SingleItemModel> mPosts;

    public CommentFollowersModel(SiteModel site, JSONObject response) throws JSONException {
        super(site);
        this.mPage = response.getInt("page");
        this.mPages = response.getInt("pages");
        this.mTotal = response.getInt("total");

        JSONArray postsJSONArray = response.optJSONArray("posts");
        if (postsJSONArray != null) {
            mPosts = new ArrayList<>(postsJSONArray.length());
            for (int i = 0; i < postsJSONArray.length(); i++) {
                JSONObject currentPostJSON = postsJSONArray.getJSONObject(i);
                String postId = String.valueOf(currentPostJSON.getInt("id"));
                String title = currentPostJSON.getString("title");
                int followers = currentPostJSON.getInt("followers");
                String url = currentPostJSON.getString("url");
                SingleItemModel currentPost = new SingleItemModel(site, null, postId, title, followers, url, null);
                mPosts.add(currentPost);
            }
        }
    }

    public List<SingleItemModel> getPosts() {
        return this.mPosts;
    }

    public int getTotal() {
        return mTotal;
    }

    public int getPage() {
        return mPage;
    }

    public int getPages() {
        return mPages;
    }

}
