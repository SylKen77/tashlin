package org.tashlin.core.service;

import java.util.List;

import org.tashlin.core.model.JobDefinition;

public interface JobService {

	JobDefinition getJob(String key);
	
	List<JobDefinition> getJobs();
	
	void schedule(String key);
	
	String getStatus(String key);
	
	void save(JobDefinition job);
	
	void delete(String key);
	
}
