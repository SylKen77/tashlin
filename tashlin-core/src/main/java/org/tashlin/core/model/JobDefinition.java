package org.tashlin.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

public class JobDefinition {
	
	private String key;
	private int lastBuildNr;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String cronSchedule;
	
	public int addLastBuildNr() {
		return ++lastBuildNr;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCronSchedule() {
		return cronSchedule;
	}

	public void setCronSchedule(String cronSchedule) {
		this.cronSchedule = cronSchedule;
	}
	
	public int getLastBuildNr() {
		return lastBuildNr;
	}

	public void setLastBuildNr(int lastBuildNr) {
		this.lastBuildNr = lastBuildNr;
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
