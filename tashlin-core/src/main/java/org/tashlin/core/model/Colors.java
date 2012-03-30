package org.tashlin.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

public class Colors {

	@NotBlank
	private String success;
	
	@NotBlank
	private String failed;
	
	@NotBlank
	private String unknown;
	
	public Colors() {
		this.success = "#5EB95E";
		this.failed = "#DD514C";
		this.unknown = "#DDDDDD";
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFailed() {
		return failed;
	}

	public void setFailed(String failed) {
		this.failed = failed;
	}

	public String getUnknown() {
		return unknown;
	}

	public void setUnknown(String unknown) {
		this.unknown = unknown;
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
