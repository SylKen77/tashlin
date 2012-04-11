package org.tashlin.core.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tashlin.core.dao.ConfigurationDao;
import org.tashlin.core.exception.ServiceException;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.model.JobDefinition;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	
	private Configuration configuration;
	@Autowired private FileSystemService fileSystemService;
	@Autowired private ConfigurationDao configurationDao;
	
	public JobDefinition getJob(String name) {
		checkConfiguration();
		return configuration.getJobs().get(name);
	}

	public List<JobDefinition> getJobs() {
		checkConfiguration();
		if(configuration.getJobs() != null) {
			return new ArrayList<JobDefinition>(configuration.getJobs().values());
		}
		return null;
	}
	
	public GlobalSettings getGlobalSettings() {
		checkConfiguration();
		return configuration.getGlobalSettings();
	}
	
	public void save(GlobalSettings globalSettings) {
		checkConfiguration();
		configuration.setGlobalSettings(globalSettings);
		save(configuration);
	}
	
	public void save(JobDefinition job) {
		checkConfiguration();
		if(configuration.getJobs() == null) {
			configuration.setJobs(new LinkedHashMap<String, JobDefinition>());
		}
		configuration.getJobs().put(job.getKey(), job);
		save(configuration);
	}
	
	private void save(Configuration configuration) {
		try {
			File configFile = fileSystemService.getConfigFile();
			configurationDao.save(configFile, configuration);
		} catch (IOException e) {
			throw new ServiceException();
		}
	}
	
	public void delete(String key) {
		checkConfiguration();
		configuration.getJobs().remove(key);
		save(configuration);
	}
	
	private void checkConfiguration() {
		if(configuration == null) {
			loadConfiguration();
		}
	}

	public void loadConfiguration() {
		try {
			File configFile = fileSystemService.getConfigFile();
			this.configuration = configurationDao.getConfiguration(configFile);
		} catch(IOException e) {
			throw new ServiceException();
		}
	}

}
