package org.tashlin.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import org.tashlin.core.builder.GlobalSettingsBuilder;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.service.SettingService;
import org.tashlin.test.AbstractUnitTest;

public class SettingControllerTest extends AbstractUnitTest {
	
	private SettingController controller;
	private MockHttpServletRequest request;
	private GlobalSettingsBuilder globalSettingsBuilder;
	@Mock private SettingService settingService;
	@Mock private BindingResult bindingResult;
	
	@Before
	public void setUp() {
		controller = new SettingController();
		request = new MockHttpServletRequest();
		globalSettingsBuilder = new GlobalSettingsBuilder();
		ReflectionTestUtils.setField(controller, "settingService", settingService);
	}
	
	@Test
	public void testShowSettings() {
		GlobalSettings globalSettings = globalSettingsBuilder.mock().build();
		when(settingService.getSettings()).thenReturn(globalSettings);
		assertEquals(".settings.overview", controller.showSettings(request));
		assertEquals(globalSettings, request.getAttribute("globalSettings"));
	}
	
	@Test
	public void testSave() {
		GlobalSettings globalSettings = globalSettingsBuilder.mock().build();
		assertEquals("redirect:/jobs", controller.save(globalSettings, bindingResult));
		verify(settingService).save(globalSettings);
	}
	
	@Test
	public void testSaveButValidationFailed() {
		when(bindingResult.hasErrors()).thenReturn(true);
		GlobalSettings globalSettings = globalSettingsBuilder.mock().build();
		assertEquals(".settings.overview", controller.save(globalSettings, bindingResult));
		verifyZeroInteractions(settingService);
	}

}
