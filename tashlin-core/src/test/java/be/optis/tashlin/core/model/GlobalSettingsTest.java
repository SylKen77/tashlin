package be.optis.tashlin.core.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GlobalSettingsTest {

	public GlobalSettings globalSettings;
	
	@Before
	public void setUp() {
		globalSettings = new GlobalSettings();
	}
	
	@Test
	public void testDefaultValues() {
		assertEquals(new Colors(), globalSettings.getColors());
		assertNull(globalSettings.getMavenHome());
	}
	
	@Test
	public void testHashCode() {
		GlobalSettings otherGlobalSettings = new GlobalSettings();
		assertEquals(otherGlobalSettings.hashCode(), otherGlobalSettings.hashCode());
	}
	
}
