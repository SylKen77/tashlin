package be.optis.tashlin.core.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.ConfigBuilder;
import be.optis.tashlin.test.AbstractIntegrationTest;

public class XmlConfigDaoIntegrationTest extends AbstractIntegrationTest {

	private XmlConfigDao dao;
	private Config config;
	private static final File TEST_XML_FILE = new File("src/test/resources/config.xml");
	private static final File TEST_TEMP_XML_FILE = new File("target/config-temp.xml");

	
	@Before
	public void setUp() {
		config = new ConfigBuilder().mock().andReturn();
		dao = new XmlConfigDao(TEST_XML_FILE);
	}
	
	@Test
	public void testGetConfig() throws Exception {
		assertEquals(config, dao.getConfig());
	}

	@Test
	public void testSave() throws Exception {
		dao = new XmlConfigDao(TEST_TEMP_XML_FILE);
		dao.save(config);
		String expected = FileUtils.readFileToString(TEST_XML_FILE);
		String actual = FileUtils.readFileToString(TEST_TEMP_XML_FILE);
		assertEquals(expected, actual);
	}
	
	@After
	public void tearDown() {
		TEST_TEMP_XML_FILE.delete();
		
	}
	

}
