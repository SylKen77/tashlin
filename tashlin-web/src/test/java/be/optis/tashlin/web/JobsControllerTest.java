package be.optis.tashlin.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

import be.optis.tashlin.core.service.JobService;
import be.optis.tashlin.test.AbstractUnitTest;

public class JobsControllerTest extends AbstractUnitTest {

	private JobsController controller;
	private MockHttpServletResponse response;
	@Mock private JobService jobService;
	
	@Before
	public void setUp() {
		controller = new JobsController();
		response = new MockHttpServletResponse();
		ReflectionTestUtils.setField(controller, "jobService", jobService);
	}
	
	@Test
	public void showJobs() {
		assertEquals(".jobs.overview", controller.showJobs());
	}
	
	@Test
	public void build() throws Exception {
		controller.build(response);
		verify(jobService).triggerBuild();
	}
	
}
