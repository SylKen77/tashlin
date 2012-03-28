package org.tashlin.core.builder;

import org.tashlin.core.model.JobDefinition;

public class JobDefinitionBuilder {

	private JobDefinition jobDefiniton;
	
	public JobDefinitionBuilder mock() {
		jobDefiniton = new JobDefinition();
		jobDefiniton.setKey("tashlin-build");
		jobDefiniton.setName("tashlin-build");
		jobDefiniton.setCronSchedule("0 * * * *");
		return this;
	}
	
	public JobDefinitionBuilder withKey(String key) {
		jobDefiniton.setKey(key);
		return this;
	}
	
	public JobDefinitionBuilder withName(String name) {
		jobDefiniton.setName(name);
		return this;
	}
	
	public JobDefinition build() {
		return jobDefiniton;
	}
	
}
