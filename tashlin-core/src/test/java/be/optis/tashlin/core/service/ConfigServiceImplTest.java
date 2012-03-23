package be.optis.tashlin.core.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.channels.FileLockInterruptionException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import be.optis.tashlin.core.dao.ConfigDao;
import be.optis.tashlin.core.exception.ServiceException;
import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.ConfigBuilder;
import be.optis.tashlin.core.model.GlobalSettings;
import be.optis.tashlin.core.model.GlobalSettingsBuilder;
import be.optis.tashlin.test.AbstractUnitTest;

public class ConfigServiceImplTest extends AbstractUnitTest {

	private ConfigServiceImpl service;
	private Config config;
	@Mock private ConfigDao configDao;
	
	@Before
	public void setUp() {
		service = new ConfigServiceImpl();
		config = new Config();
		ReflectionTestUtils.setField(service, "configDao", configDao);
	}
	
	@Test
	public void testGetGlobalSettings() throws Exception {
		when(configDao.getConfig()).thenReturn(new ConfigBuilder().mock().andReturn());
		GlobalSettings expected = new GlobalSettingsBuilder().mock().andReturn();
		assertEquals(expected, service.getGlobalSettings());
	}
	
	@Test
	public void testGetGlobalSettingsWhenConfigDoesNotExist() throws Exception {
		when(configDao.getConfig()).thenReturn(null);
		GlobalSettings expected = new GlobalSettings();
		assertEquals(expected, service.getGlobalSettings());
	}
	
	@Test(expected=ServiceException.class)
	public void testGetGlobalSettingButFileIsLocked() throws Exception {
		doThrow(new FileLockInterruptionException()).when(configDao).getConfig();
		service.getGlobalSettings();
	}
	
	@Test
	public void testSave() throws Exception {
		service.save(config.getGlobalSettings());
		verify(configDao).save(any(Config.class));
	}
	
	@Test(expected=ServiceException.class)
	public void testSaveButFileIsLocked() throws Exception {
		doThrow(new FileLockInterruptionException()).when(configDao).save(config);
		service.save(config.getGlobalSettings());
	}
	
}
