package org.tashlin.core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.util.StringUtils;
import org.tashlin.core.builder.ConfigurationBuilder;
import org.tashlin.core.model.Configuration;

public class XstreamConfigurationDaoIntegrationTest {

	private static final File TEST_XML_FILE = new File("src/test/resources/config.xml");
	private XstreamConfigurationDao dao;
	private File configFile;
	@Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Before
	public void setUp() throws Exception {
		dao = new XstreamConfigurationDao();	
		configFile = temporaryFolder.newFile("config.xml");
	}
	
	@Test
	public void testGetConfiguration() throws Exception {
		Configuration configuration = dao.getConfiguration(TEST_XML_FILE);
		assertEquals(new ConfigurationBuilder().mock().build(), configuration);
	}
	
	@Test
	public void testGetConfigurationThatDoesntExist() throws Exception {
		File newConfigFile = new File(temporaryFolder.getRoot() + "/.tashlin/config.xml");
		dao.getConfiguration(newConfigFile);
		assertTrue(newConfigFile.exists());
	}
		
	@Test
	public void testSave() throws Exception {
		dao.save(configFile, new ConfigurationBuilder().mock().build());
		String expected = StringUtils.trimAllWhitespace(FileUtils.readFileToString(TEST_XML_FILE));
		String actual = StringUtils.trimAllWhitespace(FileUtils.readFileToString(configFile));
		assertEquals(expected, actual);
	}
	
}
