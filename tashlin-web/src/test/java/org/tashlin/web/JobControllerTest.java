package org.tashlin.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.tashlin.core.builder.JobDefinitionBuilder;
import org.tashlin.core.model.JobDefinition;
import org.tashlin.core.service.JobService;

@RunWith(MockitoJUnitRunner.class)
public class JobControllerTest {

	private JobController controller;
	private MockHttpServletRequest request;
	private Model model;
	private JobDefinitionBuilder jobDefinitionBuilder;
	@Mock private JobService jobService;
	@Mock private BindingResult bindingResult;
	
	@Before
	public void setUp() {
		controller = new JobController();
		request = new MockHttpServletRequest();
		model = new ExtendedModelMap();
		jobDefinitionBuilder = new JobDefinitionBuilder();
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
	
	@Test
	public void testAddJob() {
		assertEquals(".job.add", controller.addJob(model));
		assertEquals(new JobDefinition(), model.asMap().get("jobDefinition"));
	}
	
	@Test
	public void testSaveJob() {
		when(bindingResult.hasErrors()).thenReturn(false);
		JobDefinition job = jobDefinitionBuilder.mock().build();
		assertEquals("redirect:/jobs", controller.saveJob(job, bindingResult));
		verify(jobService).save(job);
	}
	
	@Test
	public void testSaveJobWithErrors() {
		when(bindingResult.hasErrors()).thenReturn(true);
		JobDefinition job = jobDefinitionBuilder.mock().build();
		assertEquals(".job.add", controller.saveJob(job, bindingResult));
		verifyZeroInteractions(jobService);
	}
	
	@Test
	public void testDeleteJob() {
		assertEquals("redirect:/jobs", controller.deleteJob("tashlin-build"));
		//verify(jobService).delete("tashlin-build");
	}
	
}
