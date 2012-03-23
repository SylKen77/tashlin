package be.optis.tashlin.core.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.util.ReflectionTestUtils;

import be.optis.tashlin.core.exception.ServiceException;
import be.optis.tashlin.test.AbstractUnitTest;

public class JobServiceImplTest extends AbstractUnitTest {

	private JobServiceImpl service;
	private SchedulerFactoryBean quartzScheduler;
	@Mock private Scheduler scheduler;
	
	@Before
	public void setUp() {
		service = new JobServiceImpl();
		quartzScheduler = new SchedulerFactoryBean() {
			public Scheduler getObject() {
				return scheduler;
			}
		};
		ReflectionTestUtils.setField(service, "quartzScheduler", quartzScheduler);
	}
	
	@Test
	public void testTriggerBuild() throws Exception {
		service.triggerBuild();
		verify(scheduler).scheduleJob(any(JobDetail.class), any(Trigger.class));
	}
	
	@Test(expected=ServiceException.class)
	public void testTriggerBuildFailed() throws Exception {
		doThrow(new SchedulerException()).when(scheduler).scheduleJob(any(JobDetail.class), any(Trigger.class));
		service.triggerBuild();
	}
	
}

