package org.tashlin.core.build;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.tashlin.core.builder.JobDefinitionBuilder;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuildJobTest {

	private BuildJob buildJob; 
	@Mock private JobExecutionContext ctx;
	@Mock private JobDetail jobDetail;
	@Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Before
	public void setUp() {
		buildJob = new BuildJob();
	}
	
	@Test
	public void testExecute() throws Exception {
		JobDataMap map = new JobDataMap();
		map.put("jobDefinition", new JobDefinitionBuilder().mock().build());
		map.put("rootFolder", temporaryFolder.getRoot());
		when(ctx.getJobDetail()).thenReturn(jobDetail);
		when(jobDetail.getJobDataMap()).thenReturn(map);
		buildJob.execute(ctx);
	}
	
}
