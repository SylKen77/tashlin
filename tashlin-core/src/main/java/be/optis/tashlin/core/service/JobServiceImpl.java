package be.optis.tashlin.core.service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import be.optis.tashlin.core.build.BuildJob;
import be.optis.tashlin.core.exception.ServiceException;

@Service
public class JobServiceImpl implements JobService {

	@Autowired private SchedulerFactoryBean quartzScheduler;
	
	public void triggerBuild() {
		try {
			JobDetail job = newJob(BuildJob.class).build();
			Trigger trigger = newTrigger().startNow().build();
			quartzScheduler.getObject().scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			throw new ServiceException();
		}
	}

}
