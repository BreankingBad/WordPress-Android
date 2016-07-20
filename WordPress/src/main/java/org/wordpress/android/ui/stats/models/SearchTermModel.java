package org.wordpress.android.ui.stats.models;

import org.wordpress.android.stores.model.SiteModel;

import java.io.Serializable;

public class SearchTermModel extends SingleItemModel implements Serializable {

    private final boolean mIsEncriptedTerms;

    public SearchTermModel(SiteModel site, String date, String title, int totals, boolean isEncriptedTerms) {
        super(site, date, null, title, totals, null, null);
        this.mIsEncriptedTerms = isEncriptedTerms;
    }

    public boolean isEncriptedTerms() {
        return mIsEncriptedTerms;
    }

}
