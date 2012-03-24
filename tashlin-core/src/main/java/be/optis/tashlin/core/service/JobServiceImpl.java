package be.optis.tashlin.core.service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import be.optis.tashlin.core.build.MavenBuildStrategy;
import be.optis.tashlin.core.build.TashlinJob;
import be.optis.tashlin.core.exception.ServiceException;
import be.optis.tashlin.core.model.JobSettings;

@Service
public class JobServiceImpl implements JobService {

	@Autowired private SchedulerFactoryBean quartzScheduler;
	
	public void triggerBuild() {
		try {
			JobDataMap dataMap = new JobDataMap();
			dataMap.put("buildStrategy", new MavenBuildStrategy());
			JobDetail job = newJob(TashlinJob.class).usingJobData(dataMap).build();
			Trigger trigger = newTrigger().startNow().build();			
			quartzScheduler.getObject().scheduleJob(job, trigger);
			
			
		} catch (SchedulerException e) {
			throw new ServiceException();
		}
	}

	public List<JobSettings> getJobs() {
		List<JobSettings> jobs = new ArrayList<JobSettings>();
		jobs.add(new JobSettings("test-job1"));
		jobs.add(new JobSettings("test-job2"));
		return jobs;
	}

}
