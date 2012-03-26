package org.tashlin.core.service;

import java.util.List;

import org.tashlin.core.model.JobDefinition;

public interface JobService {

	JobDefinition getJob(String name);
	
	List<JobDefinition> getJobs();
	
	void schedule(String name);
	
	String getStatus(String name);
	
}
