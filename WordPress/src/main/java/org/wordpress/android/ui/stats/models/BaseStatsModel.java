package org.wordpress.android.ui.stats.models;

import org.wordpress.android.stores.model.SiteModel;

import java.io.Serializable;

public class BaseStatsModel implements Serializable {
    protected SiteModel mSite;

    public BaseStatsModel(SiteModel site) {
        mSite = site;
    }

    public SiteModel getSite() {
        return mSite;
    }
}
