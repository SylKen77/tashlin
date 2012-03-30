package org.tashlin.core.build;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.tashlin.core.model.GlobalSettings;

public class BuildJob implements Job {

	private GlobalSettings globalSettings;
	
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		JobDataMap jobDataMap = ctx.getMergedJobDataMap();
		System.out.println("// WE ARE RUNNING: " + globalSettings);
	}

	public void setGlobalSettings(GlobalSettings globalSettings) {
		this.globalSettings = globalSettings;
	}
	
	

}
