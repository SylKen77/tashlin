package be.optis.tashlin.core.service;

import java.util.Set;

import be.optis.tashlin.core.domain.Job;

public interface JobService {

	Set<Job> getJobs();
	
	Job getJob(Long id);
	
}
