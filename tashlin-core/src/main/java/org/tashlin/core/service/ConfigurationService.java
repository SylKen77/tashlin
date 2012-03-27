package org.tashlin.core.service;

import java.util.List;

import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.model.JobDefinition;

public interface ConfigurationService {

	JobDefinition getJob(String name);
	
	List<JobDefinition> getJobs();
	
	GlobalSettings getGlobalSettings();
	
	void save(GlobalSettings globalSettings);
	
}
