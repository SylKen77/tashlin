package org.tashlin.core.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;
import org.tashlin.core.builder.ConfigurationBuilder;
import org.tashlin.core.builder.JobDefinitionBuilder;
import org.tashlin.core.dao.ConfigurationDao;
import org.tashlin.core.exception.ServiceException;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.JobDefinition;

import static org.mockito.Mockito.*;

import org.tashlin.test.AbstractUnitTest;

public class ConfigurationServiceImplTest extends AbstractUnitTest {

	private ConfigurationServiceImpl service;
	private ConfigurationBuilder configurationBuilder;
	private JobDefinitionBuilder jobDefinitionBuilder;
	@Mock private ConfigurationDao configurationDao;
	
	@Before
	public void setUp() {
		service = new ConfigurationServiceImpl();
		configurationBuilder = new ConfigurationBuilder();
		jobDefinitionBuilder = new JobDefinitionBuilder();
		ReflectionTestUtils.setField(service, "configurationDao", configurationDao);
	}
	
	@Test
	public void testGetJob() throws IOException {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration()).thenReturn(configuration);
		JobDefinition jobDefinition = new JobDefinitionBuilder().mock().build();
		assertEquals(jobDefinition, service.getJob("tashlin-build"));
	}
	
	@Test
	public void testGetJobAndKeepConfigurationInCache() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration()).thenReturn(configuration);
		service.getJob("tashlin-build");
		service.getJob("tashlin-build");
		verify(configurationDao).getConfiguration();
		verifyNoMoreInteractions(configurationDao);
	}
	
	@Test(expected=ServiceException.class)
	public void testGetJobCannotRetrieveFromDao() throws Exception {
		doThrow(new IOException()).when(configurationDao).getConfiguration();
		service.getJob("tashlin-build");
	}
	
	@Test
	public void testGetJobs() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration()).thenReturn(configuration);
		List<JobDefinition> jobs = service.getJobs();
		assertEquals(jobDefinitionBuilder.mock().build(), jobs.get(0));
		assertEquals(jobDefinitionBuilder.mock().withName("tashlin-integration").build(), jobs.get(1));
	}
	
	@Test
	public void testGetJobsAndKeepConfigurationInCache() throws Exception {
		Configuration configuration = configurationBuilder.mock().build();
		when(configurationDao.getConfiguration()).thenReturn(configuration);
		service.getJobs();
		service.getJobs();
		verify(configurationDao).getConfiguration();
		verifyNoMoreInteractions(configurationDao);
	}
	
	@Test(expected=ServiceException.class)
	public void testGetJobsCannotRetrieveFromDao() throws Exception {
		doThrow(new IOException()).when(configurationDao).getConfiguration();
		service.getJobs();
	}
	
}
