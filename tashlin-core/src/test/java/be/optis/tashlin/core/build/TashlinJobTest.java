package be.optis.tashlin.core.build;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import static org.mockito.Mockito.*;

import be.optis.tashlin.test.AbstractUnitTest;

public class TashlinJobTest extends AbstractUnitTest {

	private TashlinJob buildJob;
	private JobDataMap jobDataMap;
	@Mock private JobExecutionContext ctx;
	@Mock private JobDetail jobDetail;
	@Mock private BuildStrategy buildStrategy;
	
	@Before
	public void setUp() {
		buildJob = new TashlinJob();
		jobDataMap = new JobDataMap();
		jobDataMap.put("buildStrategy", buildStrategy);
	}
	
	@Test
	public void testExecute() throws Exception {
		when(ctx.getJobDetail()).thenReturn(jobDetail);
		when(jobDetail.getJobDataMap()).thenReturn(jobDataMap);
		buildJob.execute(ctx);
		verify(buildStrategy).build();
	}
	
}
