package be.optis.tashlin.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.optis.tashlin.test.AbstractUnitTest;

public class SettingsControllerTest extends AbstractUnitTest {

	private SettingsController controller;
	
	@Before
	public void setUp() {
		controller = new SettingsController();
	}
	
	@Test
	public void showSettings() {
		assertEquals(".settings.overview", controller.showSettings());
	}
	
	@Test
	public void save() {
		assertEquals(".settings.overview", controller.save());
	}
	
}
