package be.optis.tashlin.web;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

import be.optis.tashlin.core.domain.Job;
import be.optis.tashlin.core.service.JobService;
import be.optis.tashlin.test.AbstractUnitTest;

public class JobControllerTest extends AbstractUnitTest {

	private JobController controller;
	private MockHttpServletRequest request;
	@Mock private JobService jobService;
	
	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		controller = new JobController();
		ReflectionTestUtils.setField(controller, "jobService", jobService);
	}
	
	@Test
	public void testView() {
		List<Job> jobs = new ArrayList<Job>();
		when(jobService.getJobs()).thenReturn(jobs);
		assertEquals(".jobs", controller.view(request));
		assertEquals(jobs, request.getAttribute("jobs"));
	}
	
}
