package org.tashlin.core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.StringUtils;
import org.tashlin.core.builder.ConfigurationBuilder;
import org.tashlin.core.model.Configuration;

public class XmlConfigurationDaoImplIntegrationTest {

	private XmlConfigurationDao dao;
	private static final File TEST_XML_FILE = new File("src/test/resources/config.xml");
	private static final File TEST_TEMP_XML_FILE = new File("target/config-temp.xml");

	@Test
	public void testGetConfiguration() throws Exception {
		dao = new XmlConfigurationDao(TEST_XML_FILE);
		Configuration configuration = dao.getConfiguration();
		assertEquals(new ConfigurationBuilder().mock().build(), configuration);
	}
	
	@Test
	public void testGetConfigurationWhenConfigDoesNotExist() throws Exception {
		File source = new File("target/unexisting-config.xml");
		dao = new XmlConfigurationDao(source);
		dao.getConfiguration();
		assertTrue(source.exists());
		source.delete();
	}
	
	@Test
	public void testSave() throws Exception {
		dao = new XmlConfigurationDao(TEST_TEMP_XML_FILE);
		dao.save(new ConfigurationBuilder().mock().build());
		String expected = StringUtils.trimAllWhitespace(FileUtils.readFileToString(TEST_XML_FILE));
		String actual = StringUtils.trimAllWhitespace(FileUtils.readFileToString(TEST_TEMP_XML_FILE));
		assertEquals(expected, actual);
	}
	
}
