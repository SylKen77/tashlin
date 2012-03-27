package org.tashlin.core.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;
import org.tashlin.core.builder.GlobalSettingsBuilder;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.test.AbstractUnitTest;

public class SettingServiceImplTest extends AbstractUnitTest {

	private SettingService service;
	private GlobalSettingsBuilder globalSettingsBuilder;
	@Mock private ConfigurationService configurationService;
	
	@Before
	public void setUp() {
		service = new SettingServiceImpl();
		globalSettingsBuilder = new GlobalSettingsBuilder();
		ReflectionTestUtils.setField(service, "configurationService", configurationService);
	}
	
	@Test
	public void testGetSettings() {
		GlobalSettings globalSettings = globalSettingsBuilder.mock().build();
		when(configurationService.getGlobalSettings()).thenReturn(globalSettings);
		assertEquals(globalSettings, service.getSettings());
	}
	
	@Test
	public void testSave() {
		GlobalSettings globalSettings = globalSettingsBuilder.mock().build();
		service.save(globalSettings);
		verify(configurationService).save(globalSettings);
	}
	
}
