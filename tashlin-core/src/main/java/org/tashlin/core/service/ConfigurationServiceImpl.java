package org.tashlin.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tashlin.core.dao.ConfigurationDao;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.JobDefinition;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	
	private ConfigurationDao configurationDao;
	private Configuration configuration;
	
	public JobDefinition getJob(String name) {
		checkConfiguration();
		return configuration.getJobs().get(name);
	}

	public List<JobDefinition> getJobs() {
		checkConfiguration();
		return new ArrayList<JobDefinition>(configuration.getJobs().values());
	}
	
	private void checkConfiguration() {
		if(configuration == null) {
			this.configuration = configurationDao.getConfiguration();
		}
	}

	
	
}
