package be.optis.tashlin.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;

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
	public void showJobs() {
		Set<Job> jobs = new LinkedHashSet<Job>();
		jobs.add(new Job(1L, "Job1"));
		when(jobService.getJobs()).thenReturn(jobs);
		assertEquals(".jobs.overview", controller.showJobs(request));
		assertEquals(jobs, request.getAttribute("jobs"));
	}
	
	@Test
	public void showJobsNoJobsFound() {
		Set<Job> jobs = new LinkedHashSet<Job>();
		when(jobService.getJobs()).thenReturn(jobs);
		assertEquals(".jobs.overview", controller.showJobs(request));
		assertNull(request.getAttribute("jobs"));
	}
	
	@Test
	public void showJobDetail() {
		Job job = new Job(1L, "Job1");
		when(jobService.getJob(1L)).thenReturn(job);
		assertEquals(".jobs.detail", controller.showJobDetail(request, 1L));
		assertEquals(job, request.getAttribute("job"));
	}
	
	@Test
	public void runBuild() {
		assertEquals(".jobs.detail", controller.runBuild());
	}
	
}
