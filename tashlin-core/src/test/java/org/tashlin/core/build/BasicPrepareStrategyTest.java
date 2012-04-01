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
		File buildsFolder = temporaryFolder.newFolder("jobs/tashlin-build/builds");
		buildsFolder.mkdirs();
		strategy.prepare(temporaryFolder.getRoot(), job);
		assertTrue(new File(buildsFolder + "/5").exists());
		assertEquals(5, job.getLastBuildNr());
	}
	
	@Test
	public void testPrepareWhenBuildsFolderDoesntExist() throws Exception {
		File tashlinBuildFolder = temporaryFolder.newFolder("jobs/tashlin-build");
		tashlinBuildFolder.mkdirs();
		strategy.prepare(temporaryFolder.getRoot(), job);
		assertTrue(new File(tashlinBuildFolder + "/builds/5").exists());
		assertEquals(5, job.getLastBuildNr());
	}
	
	@Test
	public void testPrepareWhenTashlinBuildFolderDoesntExist() throws Exception {
		File jobsFolder = temporaryFolder.newFolder("jobs");
		strategy.prepare(temporaryFolder.getRoot(), job);
		assertTrue(new File(jobsFolder + "/tashlin-build/builds/5").exists());
		assertEquals(5, job.getLastBuildNr());
	}
	
	@Test
	public void testPrepareWhenJobsFolderDoesntExist() throws Exception {
		strategy.prepare(temporaryFolder.getRoot(), job);
		assertTrue(new File(temporaryFolder.getRoot() + "/jobs/tashlin-build/builds/5").exists());
		assertEquals(5, job.getLastBuildNr());
	}
	
}
