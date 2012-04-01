package org.tashlin.core.build;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.tashlin.core.model.JobDefinition;

public class BasicPrepareStrategy implements PrepareStrategy {

	public void prepare(File rootFolder, JobDefinition job) throws IOException {
		int buildNr = job.addLastBuildNr();
		
		
		File buildFolder = new File(rootFolder + "/jobs/" + job.getKey() + "/builds/" + buildNr);
		buildFolder.mkdirs();
		
		
	}

}
