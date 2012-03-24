package be.optis.tashlin.core.service;

import java.util.List;

import be.optis.tashlin.core.model.JobSettings;

public interface JobService {

	void triggerBuild();
	
	List<JobSettings> getJobs();
	
}
