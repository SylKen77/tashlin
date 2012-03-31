package org.tashlin.core.build;

import java.io.File;
import java.io.IOException;

import org.tashlin.core.model.JobDefinition;

public interface PrepareStrategy {

	void prepare(File rootFolder, JobDefinition job) throws IOException;
	
}
