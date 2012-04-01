package org.tashlin.core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.util.StringUtils;
import org.tashlin.core.builder.ConfigurationBuilder;
import org.tashlin.core.model.Configuration;

public class XmlConfigurationDaoImplIntegrationTest {

	private static final File TEST_XML_FILE = new File("src/test/resources/config.xml");
	private XmlConfigurationDao dao;
	@Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void testGetConfiguration() throws Exception {
		dao = new XmlConfigurationDao(TEST_XML_FILE);
		Configuration configuration = dao.getConfiguration();
		assertEquals(new ConfigurationBuilder().mock().build(), configuration);
	}
	
	@Test
	public void testGetConfigurationWhenConfigDoesntexist() throws Exception {
		File tashlinRoot = temporaryFolder.newFolder("/tashlin");
		File configFile = new File(tashlinRoot + "/config.xml");	
		dao = new XmlConfigurationDao(configFile);
		dao.getConfiguration();
		assertTrue(configFile.exists());
	}
	
	@Test
	public void testGetConfigurationWhenRootFolderDoesntExist() throws Exception {
		File configFile = new File(temporaryFolder.getRoot() + "/tashlin/config.xml");
		dao = new XmlConfigurationDao(configFile);
		dao.getConfiguration();
		assertTrue(configFile.exists());
	}
	
	@Test
	public void testSave() throws Exception {
		File tempXmlFile = temporaryFolder.newFile("config.xml");
		dao = new XmlConfigurationDao(tempXmlFile);
		dao.save(new ConfigurationBuilder().mock().build());
		String expected = StringUtils.trimAllWhitespace(FileUtils.readFileToString(TEST_XML_FILE));
		String actual = StringUtils.trimAllWhitespace(FileUtils.readFileToString(tempXmlFile));
		assertEquals(expected, actual);
	}
	
}
