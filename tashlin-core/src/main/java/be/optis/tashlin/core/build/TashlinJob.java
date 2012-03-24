package be.optis.tashlin.core.build;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TashlinJob implements Job {

	private BuildStrategy buildStrategy;
	
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
		buildStrategy = (BuildStrategy) dataMap.get("buildStrategy"); 
		buildStrategy.build();
	}


	

}
