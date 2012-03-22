package be.optis.tashlin.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PluginsControllerTest {

	private PluginsController controller;
	
	@Before
	public void setUp() {
		controller = new PluginsController();
	}
	
	@Test
	public void testShowJobs() {
		assertEquals(".plugins.overview", controller.showPlugins());
	}
	
}
