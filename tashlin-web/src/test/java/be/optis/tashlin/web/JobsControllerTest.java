package be.optis.tashlin.web;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobsControllerTest {

	private JobsController controller;
	
	@Before
	public void setUp() {
		controller = new JobsController();
	}
	
	@Test
	public void testShowJobs() {
		assertEquals(".jobs.overview", controller.showJobs());
	}
	
}
