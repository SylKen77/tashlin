package org.tashlin.core.builder;

import org.tashlin.core.model.JobDefinition;

public class JobDefinitionBuilder {

	private JobDefinition jobDefiniton;
	
	public JobDefinitionBuilder mock() {
		jobDefiniton = new JobDefinition();
		jobDefiniton.setName("tashlin-build");
		return this;
	}
	
	public JobDefinitionBuilder withName(String name) {
		jobDefiniton.setName("tashlin-build");
		return this;
	}
	
	public JobDefinition build() {
		return jobDefiniton;
	}
	
}
