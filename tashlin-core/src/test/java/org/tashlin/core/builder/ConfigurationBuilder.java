package org.tashlin.core.builder;

import java.util.LinkedHashMap;
import java.util.Map;

import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.JobDefinition;

public class ConfigurationBuilder {

	private Configuration configuration;
	private GlobalSettingsBuilder globalSettingsBuilder;
	private JobDefinitionBuilder jobDefinitionBuilder;
	
	public ConfigurationBuilder() {
		globalSettingsBuilder = new GlobalSettingsBuilder();
		jobDefinitionBuilder = new JobDefinitionBuilder();
	}
	
	public ConfigurationBuilder mock() {
		configuration = new Configuration();
		configuration.setGlobalSettings(globalSettingsBuilder.mock().build());
		addJobs();
		return this;
	}
	
	public ConfigurationBuilder withJob(JobDefinition job) {
		configuration.getJobs().clear();
		configuration.getJobs().put(job.getKey(), job);
		return this;
	}
	
	public Configuration build() {
		return configuration;
	}
	
	private void addJobs() {
		Map<String, JobDefinition> jobs = new LinkedHashMap<String, JobDefinition>();
		jobs.put("tashlin-build", jobDefinitionBuilder.mock().build());
		jobs.put("tashlin-integration", jobDefinitionBuilder.mock().withName("tashlin-integration").withKey("tashlin-integration").build());
		configuration.setJobs(jobs);
	}
	
}
