package com.conveyal.datatools.manager.jobs;

import com.conveyal.datatools.common.status.MonitorableJob;
import com.conveyal.datatools.manager.models.FeedSource;
import com.conveyal.datatools.manager.models.FeedVersion;
import com.conveyal.datatools.manager.models.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by landon on 3/25/16.
 */
public class FetchProjectFeedsJob extends MonitorableJob {
    public static final Logger LOG = LoggerFactory.getLogger(FetchProjectFeedsJob.class);
    private Project proj;
    public Map<String, FeedVersion> result;
    private Status status;

    public FetchProjectFeedsJob (Project proj, String owner) {
        super(owner);
        this.proj = proj;
        this.status = new Status();
    }

    @Override
    public void run() {
        LOG.info("fetch job running for proj: " + proj.name);
        result = new HashMap<>();

        for(FeedSource feedSource : proj.getProjectFeedSources()) {

            if (!FeedSource.FeedRetrievalMethod.FETCHED_AUTOMATICALLY.equals(feedSource.retrievalMethod))
                continue;

            FeedVersion feedVersion = feedSource.fetch();
            LOG.info("Fetching feed for " + feedSource.id);
            result.put(feedSource.id, feedVersion);
        }
    }

    @Override
    public Status getStatus() {
        synchronized (status) {
            return status.clone();
        }
    }
}