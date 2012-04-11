package org.tashlin.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tashlin.core.builder.ConfigurationBuilder;
import org.tashlin.core.builder.GlobalSettingsBuilder;
import org.tashlin.core.builder.JobDefinitionBuilder;
import org.tashlin.core.dao.ConfigurationDao;
import org.tashlin.core.exception.ServiceException;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.model.JobDefinition;

@RunWith(MockitoJUnitRunner.class)
public class ConfigurationServiceImplTest {

	private ConfigurationServiceImpl service;
	private ConfigurationBuilder configurationBuilder;
	private GlobalSettingsBuilder globalSettingsBuilder;
	private JobDefinitionBuilder jobDefinitionBuilder;
	private File configFile;
	@Mock private FileSystemService fileSystemService;
	@Mock private ConfigurationDao configurationDao;
	@Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Before
	public void setUp() throws Exception {
		service = new ConfigurationServiceImpl();
		configurationBuilder = new ConfigurationBuilder();
		globalSettingsBuilder = new GlobalSettingsBuilder();
		jobDefinitionBuilder = new JobDefinitionBuilder();
		configFile = temporaryFolder.newFile("config.xml");
		ReflectionTestUtils.setField(service, "fileSystemService", fileSystemService);
		ReflectionTestUtils.setField(service, "configurationDao", configurationDao);
		when(fileSystemService.getConfigFile()).thenReturn(configFile);
	}
	
	@Test
	public void testGetJob() throws IOException {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		JobDefinition jobDefinition = new JobDefinitionBuilder().mock().build();
		assertEquals(jobDefinition, service.getJob("tashlin-build"));
	}
	
	@Test
	public void testGetJobAndKeepConfigurationInCache() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		service.getJob("tashlin-build");
		service.getJob("tashlin-build");
		verify(configurationDao).getConfiguration(configFile);
		verifyNoMoreInteractions(configurationDao);
	}
	
	@Test(expected=ServiceException.class)
	public void testGetJobCannotRetrieveFromDao() throws Exception {
		doThrow(new IOException()).when(configurationDao).getConfiguration(configFile);
		service.getJob("tashlin-build");
	}
	
	@Test
	public void testGetJobs() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		List<JobDefinition> jobs = service.getJobs();
		assertEquals(jobDefinitionBuilder.mock().build(), jobs.get(0));
		assertEquals(jobDefinitionBuilder.mock().withKey("tashlin-integration").withName("tashlin-integration").build(), jobs.get(1));
	}
	
	@Test
	public void testGetJobsReturnsNull() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		configuration.setJobs(null);
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		assertNull(service.getJobs());
	}
	
	@Test
	public void testGetJobsAndKeepConfigurationInCache() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		service.getJobs();
		service.getJobs();
		verify(configurationDao).getConfiguration(configFile);
		verifyNoMoreInteractions(configurationDao);
	}
	
	@Test(expected=ServiceException.class)
	public void testGetJobsCannotRetrieveFromDao() throws Exception {
		doThrow(new IOException()).when(configurationDao).getConfiguration(configFile);
		service.getJobs();
	}
	
	@Test
	public void testGetGlobalSettings() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		assertEquals(configuration.getGlobalSettings(), service.getGlobalSettings());
	}
	
	@Test
	public void testGetGlobalSettingsAndKeepConfigurationInCache() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		service.getGlobalSettings();
		service.getGlobalSettings();
		verify(configurationDao).getConfiguration(configFile);
		verifyNoMoreInteractions(configurationDao);
	}
	
	@Test
	public void testSaveGlobalSettings() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		GlobalSettings globalSettings = globalSettingsBuilder.mock().build();
		configuration.setGlobalSettings(null);
		service.save(globalSettings);
		assertEquals(globalSettings, configuration.getGlobalSettings());
		verify(configurationDao).save(configFile, configuration);
	}
	
	@Test
	public void testSaveJob() throws Exception {
		JobDefinition job = jobDefinitionBuilder.mock().build();
		Configuration cachedConfiguration = configurationBuilder.mock().build();
		cachedConfiguration.setJobs(null);
		Configuration newConfiguration = configurationBuilder.mock().withJob(job).build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(cachedConfiguration);
		service.save(job);
		verify(configurationDao).save(configFile, newConfiguration);
	}
	
	@Test
	public void testDeleteJob() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		service.delete("tashlin-build");
		assertNull(configuration.getJobs().get("tashlin-build"));
		verify(configurationDao).save(configFile, configuration);
	}
	
	@Test
	public void testDeleteJobThatDoesntExist() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration);
		service.delete("tashlin-unexist");
		verify(configurationDao).save(configFile, configuration);
	}
	
	@Test
	public void testReloadConfiguration() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		Configuration reloadedConfiguration = configurationBuilder.mock().build();
		reloadedConfiguration.getGlobalSettings().getColors().setSuccess("#000000");
		when(configurationDao.getConfiguration(configFile)).thenReturn(configuration, reloadedConfiguration);
		assertEquals(configuration.getGlobalSettings(), service.getGlobalSettings());
		service.loadConfiguration();
		assertEquals(reloadedConfiguration.getGlobalSettings(), service.getGlobalSettings());
	}
	
}
