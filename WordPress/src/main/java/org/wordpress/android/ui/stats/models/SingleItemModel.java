package org.wordpress.android.ui.stats.models;

import android.webkit.URLUtil;

import org.wordpress.android.stores.model.SiteModel;
import org.wordpress.android.ui.stats.StatsUtils;

import java.io.Serializable;

/*
* A model to represent a SINGLE stats item
*/
public class SingleItemModel implements Serializable {
    private final SiteModel mSite;
    private final String mItemID;
    private final long mDate;
    private final String mTitle;
    private final int mTotals;
    private final String mUrl;
    private final String mIcon;

    public SingleItemModel(SiteModel site, String date, String itemID, String title, int totals, String url, String
            icon) {
       this(site, StatsUtils.toMs(date), itemID, title, totals, url, icon);
    }

    SingleItemModel(SiteModel site, long date, String itemID, String title, int totals, String url, String icon) {
        this.mSite = site;
        this.mItemID = itemID;
        this.mTitle = title;
        this.mTotals = totals;

        // We could get invalid data back from the server. Check that URL is OK.
        if (!URLUtil.isValidUrl(url)) {
            this.mUrl = "";
        } else {
            this.mUrl = url;
        }

        this.mDate = date;
        this.mIcon = icon;
    }

    public String getItemID() {
        return mItemID;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getTotals() {
        return mTotals;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getIcon() {
        return mIcon;
    }

    public long getDate() {
        return mDate;
    }

    public SiteModel getSite() {
        return mSite;
    }
}
