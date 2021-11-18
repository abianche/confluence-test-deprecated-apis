package deprec.impl;

import com.atlassian.confluence.api.model.content.Space;
import com.atlassian.confluence.api.service.content.SpaceService;
import com.atlassian.scheduler.JobRunner;
import com.atlassian.scheduler.JobRunnerRequest;
import com.atlassian.scheduler.JobRunnerResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob implements JobRunner
{
    
    private final SpaceService m_spaceService;
    
    public TestJob (final SpaceService spaceService)
    
    {
        this.m_spaceService = spaceService;
    }
    
    private static final Logger LOG = LoggerFactory.getLogger (TestJob.class);
    
    @Override
    public JobRunnerResponse runJob (final JobRunnerRequest request)
    {
        final Space space = this.m_spaceService.find ().withKeys ("ds").fetchOrNull ();
        LOG.error ("TEST");
        LOG.error (space.getName ());
        return JobRunnerResponse.success ();        
    }
}
