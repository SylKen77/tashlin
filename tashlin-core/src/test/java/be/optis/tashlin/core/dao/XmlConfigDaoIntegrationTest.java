package be.optis.tashlin.core.dao;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.ConfigBuilder;
import be.optis.tashlin.test.AbstractIntegrationTest;

public class XmlConfigDaoIntegrationTest extends AbstractIntegrationTest {

	private XmlConfigDao dao;
	private static final String TEST_XML_FILE = "src/test/resources/config.xml";

	@Before
	public void setUp() {
		dao = new XmlConfigDao(TEST_XML_FILE);
	}
	
	@Test
	public void getConfig() throws Exception {
		Config expected = new ConfigBuilder().mock().andReturn();
		Config actual = dao.getConfig();
		assertEquals(expected, actual);
	}

	@Test
	public void save() throws Exception {
		String expected = FileUtils.readFileToString(new File(TEST_XML_FILE));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Config config = new ConfigBuilder().mock().andReturn();
		dao.save(config, baos);
		assertEquals(expected, baos.toString());
	}

}
