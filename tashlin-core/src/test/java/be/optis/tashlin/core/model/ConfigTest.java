package be.optis.tashlin.core.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConfigTest {

	public Config config;
	
	@Before
	public void setUp() {
		config = new Config();
	}
	
	@Test
	public void testDefaultValues() {
		assertEquals(new GlobalSettings(), config.getGlobalSettings());
	}
	
	@Test
	public void testHashCode() {
		Config otherConfig = new Config();
		assertEquals(otherConfig.hashCode(), otherConfig.hashCode());
	}
	
}
