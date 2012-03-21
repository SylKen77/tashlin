package be.optis.tashlin.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;

import be.optis.tashlin.core.model.Colors;
import be.optis.tashlin.core.model.GlobalSettings;
import be.optis.tashlin.core.service.ConfigService;
import be.optis.tashlin.test.AbstractUnitTest;

public class SettingsControllerTest extends AbstractUnitTest {

	private SettingsController controller;
	private MockHttpServletRequest request;
	@Mock private ConfigService configService;
	
	@Before
	public void setUp() {
		controller = new SettingsController();
		request = new MockHttpServletRequest();
		ReflectionTestUtils.setField(controller, "configService", configService);
	}
	
	@Test
	public void showSettings() {
		assertEquals(".settings.overview", controller.showSettings(request));
	}
	
	@Test
	public void save() {
		GlobalSettings settings = new GlobalSettings();
		settings.setColors(new Colors());
		assertEquals("redirect:/jobs", controller.save(settings));
	}
	
}
