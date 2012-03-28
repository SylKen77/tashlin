package org.tashlin.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.tashlin.core.builder.JobDefinitionBuilder;
import org.tashlin.core.exception.ServiceException;
import org.tashlin.core.model.JobDefinition;

import org.tashlin.test.AbstractUnitTest;

public class JobServiceImplTest extends AbstractUnitTest {

	private static final String TEST_JOB_NAME = "tashlin-build";
	
	private JobServiceImpl service;
	private JobDefinitionBuilder jobDefinitionBuilder;
	@Mock private SchedulerFactoryBean schedulerFactoryBean;
	@Mock private ConfigurationService configurationService;
	@Mock private Scheduler scheduler;
	
	@Before
	public void setUp() {
		service = new JobServiceImpl();
		jobDefinitionBuilder = new JobDefinitionBuilder();
		ReflectionTestUtils.setField(service, "schedulerFactoryBean", schedulerFactoryBean);
		ReflectionTestUtils.setField(service, "configurationService", configurationService);
		when(schedulerFactoryBean.getObject()).thenReturn(scheduler);
	}
	
	@Test
	public void testGetJob() {
		JobDefinition jobDefiniton = new JobDefinitionBuilder().mock().build();
		when(configurationService.getJob(TEST_JOB_NAME)).thenReturn(jobDefiniton);
		assertEquals(jobDefiniton, service.getJob(TEST_JOB_NAME));
	}
	
	@Test
	public void testGetJobs() {
		List<JobDefinition> jobsFromConfiguration = new ArrayList<JobDefinition>();
		jobsFromConfiguration.add(jobDefinitionBuilder.mock().build());
		when(configurationService.getJobs()).thenReturn(jobsFromConfiguration);
		assertEquals(new JobDefinitionBuilder().mock().build(), service.getJobs().get(0));
	}
	
	@Test
	public void testScheduleBuild() throws Exception {
		service.schedule(TEST_JOB_NAME);	
		verify(scheduler).scheduleJob(any(JobDetail.class), any(Trigger.class));
	}
	
	@Test(expected = ServiceException.class)
	public void testScheduleBuildGetsASchedulerException() throws Exception {
		doThrow(new SchedulerException()).when(scheduler).scheduleJob(any(JobDetail.class), any(Trigger.class));
		service.schedule(TEST_JOB_NAME);
	}
	
	@Test
	public void testGetStatus() {
		assertNull(service.getStatus(TEST_JOB_NAME));
	}
	
	@Test
	public void testSave() {
		JobDefinition job = jobDefinitionBuilder.mock().withKey(null).withName("Tashlin Build").build();
		service.save(job);
		verify(configurationService).save(job);
		assertEquals("tashlin+build", job.getKey());
	}
	
	@Test
	public void testCreateKey() {
		assertEquals("tashlin-build", service.createKey("tashlin-build"));
		assertEquals("tashlin+build", service.createKey("Tashlin Build"));
		assertEquals("tashlin+build", service.createKey("   Tashlin Build"));
		assertEquals("tashlin+build", service.createKey("Tashlin Build    "));
		assertEquals("tashlin+build", service.createKey("   Tashlin Build   "));
		assertNull(service.createKey(null));
	}
	
	@Test
	public void testDelete() {
		service.delete("tashlin-build");
		verify(configurationService).delete("tashlin-build");
	}
	
}
