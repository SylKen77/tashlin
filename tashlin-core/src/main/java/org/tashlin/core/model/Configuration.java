package org.tashlin.core.model;

import java.util.Map;

public class Configuration {

	private Map<String, JobDefinition> jobs;

	public Map<String, JobDefinition> getJobs() {
		return jobs;
	}

	public void setJobs(Map<String, JobDefinition> jobs) {
		this.jobs = jobs;
	}
	
}
