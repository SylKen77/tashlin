package org.tashlin.core.model;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Configuration {

	private GlobalSettings globalSettings;
	private Map<String, JobDefinition> jobs;

	public GlobalSettings getGlobalSettings() {
		return globalSettings;
	}

	public void setGlobalSettings(GlobalSettings globalSettings) {
		this.globalSettings = globalSettings;
	}

	public Map<String, JobDefinition> getJobs() {
		return jobs;
	}

	public void setJobs(Map<String, JobDefinition> jobs) {
		this.jobs = jobs;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}
