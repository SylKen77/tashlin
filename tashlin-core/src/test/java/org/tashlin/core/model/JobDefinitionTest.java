package org.tashlin.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobDefinitionTest {

	private JobDefinition job;
	
	@Before
	public void setUp() {
		job = new JobDefinition();
	}
	
	@Test
	public void testAddLastBuildNr() {
		job.setLastBuildNr(4);
		job.addLastBuildNr();
		assertEquals(5, job.getLastBuildNr());
	}
	
	@Test
	public void testAddLastBuildNrFirstBuild() {
		job.addLastBuildNr();
		assertEquals(1, job.getLastBuildNr());
	}
	
}
