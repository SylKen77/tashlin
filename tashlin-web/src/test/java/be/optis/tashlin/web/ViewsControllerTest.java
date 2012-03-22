package be.optis.tashlin.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ViewsControllerTest {

	private ViewsController controller;
	
	@Before
	public void setUp() {
		controller = new ViewsController();
	}
	
	@Test
	public void testShowJobs() {
		assertEquals(".views.overview", controller.showViews());
	}
	
}
