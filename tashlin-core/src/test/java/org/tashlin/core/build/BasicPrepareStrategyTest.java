package org.tashlin.core.build;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.tashlin.core.builder.JobDefinitionBuilder;
import org.tashlin.core.model.JobDefinition;

public class BasicPrepareStrategyTest {

	private BasicPrepareStrategy strategy;
	private JobDefinition job;
	@Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Before
	public void setUp() {
		strategy = new BasicPrepareStrategy();
		job = new JobDefinitionBuilder().mock().build();
	}
	
	@Test
	public void testPrepare() throws Exception {
		temporaryFolder.newFolder("jobs");
		temporaryFolder.newFolder("jobs/tashlin-build");
		File buildsFolder = temporaryFolder.newFolder("jobs/tashlin-build/builds");
		strategy.prepare(temporaryFolder.getRoot(), job);
		assertTrue(new File(buildsFolder + "/5").exists());
		assertEquals(5, job.getLastBuildNr());
	}
	
}
