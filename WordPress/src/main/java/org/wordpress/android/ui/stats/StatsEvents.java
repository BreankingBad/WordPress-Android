package org.wordpress.android.ui.stats;

import com.android.volley.VolleyError;

import org.wordpress.android.stores.model.SiteModel;
import org.wordpress.android.ui.stats.models.AuthorsModel;
import org.wordpress.android.ui.stats.models.ClicksModel;
import org.wordpress.android.ui.stats.models.CommentFollowersModel;
import org.wordpress.android.ui.stats.models.CommentsModel;
import org.wordpress.android.ui.stats.models.FollowersModel;
import org.wordpress.android.ui.stats.models.GeoviewsModel;
import org.wordpress.android.ui.stats.models.InsightsAllTimeModel;
import org.wordpress.android.ui.stats.models.InsightsLatestPostDetailsModel;
import org.wordpress.android.ui.stats.models.InsightsLatestPostModel;
import org.wordpress.android.ui.stats.models.InsightsPopularModel;
import org.wordpress.android.ui.stats.models.PublicizeModel;
import org.wordpress.android.ui.stats.models.ReferrersModel;
import org.wordpress.android.ui.stats.models.SearchTermsModel;
import org.wordpress.android.ui.stats.models.TagsContainerModel;
import org.wordpress.android.ui.stats.models.TopPostsAndPagesModel;
import org.wordpress.android.ui.stats.models.VideoPlaysModel;
import org.wordpress.android.ui.stats.models.VisitsModel;
import org.wordpress.android.ui.stats.service.StatsService.StatsEndpointsEnum;

public class StatsEvents {
    public static class UpdateStatusChanged {
        public final boolean mUpdating;
        public UpdateStatusChanged(boolean updating) {
            mUpdating = updating;
        }
    }

    public abstract static class SectionUpdatedAbstract {
        public final SiteModel mSite;
        public final StatsTimeframe mTimeframe;
        public final String mDate;
        public final int mMaxResultsRequested, mPageRequested;

        public SectionUpdatedAbstract(SiteModel site, StatsTimeframe timeframe, String date,
                                      final int maxResultsRequested, final int pageRequested) {
            mSite = site;
            mDate = date;
            mTimeframe = timeframe;
            mMaxResultsRequested = maxResultsRequested;
            mPageRequested = pageRequested;
        }
    }

    public static class SectionUpdateError extends SectionUpdatedAbstract {

        public final VolleyError mError;
        public final StatsEndpointsEnum mEndPointName;

        public SectionUpdateError(StatsEndpointsEnum endPointName, SiteModel site, StatsTimeframe timeframe,
                                  String date, final int maxResultsRequested, final int pageRequested, VolleyError
                                          error) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mEndPointName = endPointName;
            mError = error;
        }
    }

    public static class VisitorsAndViewsUpdated extends SectionUpdatedAbstract {

        public final VisitsModel mVisitsAndViews;

        public VisitorsAndViewsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                       final int maxResultsRequested, final int pageRequested, VisitsModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mVisitsAndViews = responseObjectModel;
        }
    }

    public static class TopPostsUpdated extends SectionUpdatedAbstract {

        public final TopPostsAndPagesModel mTopPostsAndPagesModel;

        public TopPostsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                               final int maxResultsRequested, final int pageRequested, TopPostsAndPagesModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mTopPostsAndPagesModel = responseObjectModel;
        }
    }

    public static class ReferrersUpdated extends SectionUpdatedAbstract {

        public final ReferrersModel mReferrers;

        public ReferrersUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                final int maxResultsRequested, final int pageRequested, ReferrersModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mReferrers = responseObjectModel;
        }
    }

    public static class ClicksUpdated extends SectionUpdatedAbstract {

        public final ClicksModel mClicks;

        public ClicksUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                             final int maxResultsRequested, final int pageRequested, ClicksModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mClicks = responseObjectModel;
        }
    }


    public static class AuthorsUpdated extends SectionUpdatedAbstract {

        public final AuthorsModel mAuthors;

        public AuthorsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                              final int maxResultsRequested, final int pageRequested, AuthorsModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mAuthors = responseObjectModel;
        }
    }

    public static class CountriesUpdated extends SectionUpdatedAbstract {

        public final GeoviewsModel mCountries;

        public CountriesUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                final int maxResultsRequested, final int pageRequested, GeoviewsModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mCountries = responseObjectModel;
        }
    }

    public static class VideoPlaysUpdated extends SectionUpdatedAbstract {

        public final VideoPlaysModel mVideos;

        public VideoPlaysUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                 final int maxResultsRequested, final int pageRequested, VideoPlaysModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mVideos = responseObjectModel;
        }
    }

    public static class SearchTermsUpdated extends SectionUpdatedAbstract {

        public final SearchTermsModel mSearchTerms;

        public SearchTermsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                  final int maxResultsRequested, final int pageRequested, SearchTermsModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mSearchTerms = responseObjectModel;
        }
    }

    public static class CommentsUpdated extends SectionUpdatedAbstract {

        public final CommentsModel mComments;

        public CommentsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                               final int maxResultsRequested, final int pageRequested, CommentsModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mComments = responseObjectModel;
        }
    }

    public static class CommentFollowersUpdated extends SectionUpdatedAbstract {

        public final CommentFollowersModel mCommentFollowers;

        public CommentFollowersUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                       final int maxResultsRequested, final int pageRequested, CommentFollowersModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mCommentFollowers = responseObjectModel;
        }
    }

    public static class TagsUpdated extends SectionUpdatedAbstract {

        public final TagsContainerModel mTagsContainer;

        public TagsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                              final int maxResultsRequested, final int pageRequested, TagsContainerModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mTagsContainer = responseObjectModel;
        }
    }

    public static class PublicizeUpdated extends SectionUpdatedAbstract {

        public final PublicizeModel mPublicizeModel;

        public PublicizeUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                           final int maxResultsRequested, final int pageRequested, PublicizeModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mPublicizeModel = responseObjectModel;
        }
    }

    public static class FollowersWPCOMUdated extends SectionUpdatedAbstract {

        public final FollowersModel mFollowers;

        public FollowersWPCOMUdated(SiteModel site, StatsTimeframe timeframe, String date,
                                final int maxResultsRequested, final int pageRequested, FollowersModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mFollowers = responseObjectModel;
        }
    }

    public static class FollowersEmailUdated extends SectionUpdatedAbstract {

        public final FollowersModel mFollowers;

        public FollowersEmailUdated(SiteModel site, StatsTimeframe timeframe, String date,
                                    final int maxResultsRequested, final int pageRequested, FollowersModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mFollowers = responseObjectModel;
        }
    }

    public static class InsightsAllTimeUpdated extends SectionUpdatedAbstract {

        public final InsightsAllTimeModel mInsightsAllTimeModel;

        public InsightsAllTimeUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                      final int maxResultsRequested, final int pageRequested, InsightsAllTimeModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mInsightsAllTimeModel = responseObjectModel;
        }
    }

    public static class InsightsPopularUpdated extends SectionUpdatedAbstract {

        public final InsightsPopularModel mInsightsPopularModel;

        public InsightsPopularUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                      final int maxResultsRequested, final int pageRequested, InsightsPopularModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mInsightsPopularModel = responseObjectModel;
        }
    }

    public static class InsightsLatestPostSummaryUpdated extends SectionUpdatedAbstract {

        public final InsightsLatestPostModel mInsightsLatestPostModel;

        public InsightsLatestPostSummaryUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                      final int maxResultsRequested, final int pageRequested,
                                                InsightsLatestPostModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mInsightsLatestPostModel = responseObjectModel;
        }
    }

    public static class InsightsLatestPostDetailsUpdated extends SectionUpdatedAbstract {

        public final InsightsLatestPostDetailsModel mInsightsLatestPostDetailsModel;

        public InsightsLatestPostDetailsUpdated(SiteModel site, StatsTimeframe timeframe, String date,
                                                final int maxResultsRequested, final int pageRequested,
                                                InsightsLatestPostDetailsModel responseObjectModel) {
            super(site, timeframe, date, maxResultsRequested, pageRequested);
            mInsightsLatestPostDetailsModel = responseObjectModel;
        }
    }
}
