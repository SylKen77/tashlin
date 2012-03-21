package be.optis.tashlin.core.dao;

import org.junit.Before;
import org.junit.Test;

import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.ConfigBuilder;
import be.optis.tashlin.test.AbstractIntegrationTest;

public class XmlConfigDaoIntegrationTest extends AbstractIntegrationTest {

	private XmlConfigDao dao;

	@Before
	public void setUp() {
		dao = new XmlConfigDao();
	}
	
	@Test
	public void getConfig() {
		Config expected = new ConfigBuilder().mock().andReturn();
		Config actual = dao.getConfig();
		//assertEquals(expected, actual);
	}

	@Test
	public void save() {
		dao.save(new Config());
	}

}
