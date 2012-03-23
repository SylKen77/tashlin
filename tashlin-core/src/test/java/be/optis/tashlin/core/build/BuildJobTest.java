package be.optis.tashlin.core.build;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.quartz.JobExecutionContext;

import be.optis.tashlin.test.AbstractUnitTest;

public class BuildJobTest extends AbstractUnitTest {

	private BuildJob buildJob;
	@Mock private JobExecutionContext jobExecutionContext;
	
	@Before
	public void setUp() {
		buildJob = new BuildJob();
	}
	
	@Test
	public void testExecute() throws Exception {
		buildJob.execute(jobExecutionContext);
	}
	
}
