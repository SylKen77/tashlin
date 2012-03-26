package org.tashlin.core.builder;

import org.tashlin.core.model.JobSummary;

public class JobSummaryBuilder {

	private JobSummary jobSummary;
	
	public JobSummaryBuilder mock() {
		jobSummary = new JobSummary();
		jobSummary.setName("tashlin-build");
		return this;
	}
	
	public JobSummary build() {
		return jobSummary;
	}
	
}
