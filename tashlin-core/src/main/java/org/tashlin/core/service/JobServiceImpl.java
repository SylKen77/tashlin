package org.tashlin.core.service;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.tashlin.core.build.BuildJob;
import org.tashlin.core.exception.ServiceException;
import org.tashlin.core.model.JobDefinition;

@Service
public class JobServiceImpl implements JobService {

	@Autowired private SchedulerFactoryBean schedulerFactoryBean;
	@Autowired private ConfigurationService configurationService;

	public JobDefinition getJob(String name) {
		return configurationService.getJob(name);
	}
	
	public List<JobDefinition> getJobs() {
		return configurationService.getJobs();
	}

	public void schedule(String name) {
		try {
			JobDataMap jobDataMap = new JobDataMap();
			jobDataMap.put("jobDefinition", getJob(name));
			
			JobDetail jobDetail = newJob(BuildJob.class).usingJobData(jobDataMap).build();
			Trigger trigger = newTrigger().startNow().build();
			
			// TODO: TriggerUtils?
			
			schedulerFactoryBean.getObject().scheduleJob(jobDetail, trigger);
		} catch(SchedulerException e) {
			throw new ServiceException();
		}
	}

	public String getStatus(String name) {
		return null;
	}

	public void save(JobDefinition job) {
		job.setKey(createKey(job.getName()));
		configurationService.save(job);
	}
	
	protected String createKey(String name) {
		if(name != null) {
			return StringUtils.replace(name.toLowerCase().trim(), " ", "+");
		}
		return null;
	}

	public void delete(String key) {
		configurationService.delete(key);
	}


}
