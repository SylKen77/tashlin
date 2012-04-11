package org.tashlin.core.build;

import java.io.File;
import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.tashlin.core.model.JobDefinition;

public class BuildJob implements Job {

	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		try {
			JobDataMap map = ctx.getJobDetail().getJobDataMap();
			JobDefinition job = (JobDefinition) map.get("jobDefinition");
			File rootFolder= (File) map.get("rootFolder");
			
			PrepareStrategy prepareStrategy = new BasicPrepareStrategy();
			prepareStrategy.prepare(rootFolder, job);
		} catch(IOException e) {
			throw new JobExecutionException();
		}
	}


	

}
