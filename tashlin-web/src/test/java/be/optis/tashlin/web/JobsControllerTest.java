package be.optis.tashlin.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
