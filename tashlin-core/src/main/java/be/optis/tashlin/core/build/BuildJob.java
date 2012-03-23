package be.optis.tashlin.core.build;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BuildJob implements Job {

	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		new MavenBuildStrategy().build();
	}

}
