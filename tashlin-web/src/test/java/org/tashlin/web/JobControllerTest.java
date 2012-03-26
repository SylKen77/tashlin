package org.tashlin.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.tashlin.core.builder.JobDefinitionBuilder;
import org.tashlin.core.model.JobDefinition;
import org.tashlin.core.service.JobService;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.tashlin.test.AbstractUnitTest;

public class JobControllerTest extends AbstractUnitTest {

	private JobController controller;
	private MockHttpServletRequest request;
	@Mock private JobService jobService;
	
	@Before
	public void setUp() {
		controller = new JobController();
		request = new MockHttpServletRequest();
		ReflectionTestUtils.setField(controller, "jobService", jobService);
	}
	
	@Test
	public void testShowJobs() {
		List<JobDefinition> jobs = new ArrayList<JobDefinition>();
		when(jobService.getJobs()).thenReturn(jobs);
		assertEquals(".job.overview", controller.showJobs(request));
		assertEquals(jobs, request.getAttribute("jobs"));
	}
	
	@Test
	public void testShowJobSummary() {
		JobDefinition job = new JobDefinitionBuilder().mock().build();
		when(jobService.getJob("tashlin-build")).thenReturn(job);
		assertEquals(".job.summary", controller.showJobSummary(request, "tashlin-build"));
		assertEquals(job, request.getAttribute("job"));
	}
	
	@Test
	public void testSchedule() {
		controller.schedule(request, "tashlin-build");
		verify(jobService).schedule("tashlin-build");
	}
	
	@Test
	public void testGetStatus() {
		when(jobService.getStatus("tashlin-build")).thenReturn("Build is busy");
		Map<String, String> map = controller.getStatus("tashlin-build");
		assertEquals("Build is busy", map.get("status"));
	}
	
	@Test
	public void testGetStatusNull() {
		when(jobService.getStatus("tashlin-build")).thenReturn(null);
		Map<String, String> map = controller.getStatus("tashlin-build");
		assertNull(map.get("status"));
	}
	
}
