package be.optis.tashlin.core.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ColorsTest {

	public Colors colors;
	
	@Before
	public void setUp() {
		colors = new Colors();
	}
	
	@Test
	public void testDefaultValues() {
		assertEquals("green", colors.getSuccess());
	}
	
	@Test
	public void testHashCode() {
		Colors otherColors = new Colors();
		assertEquals(colors.hashCode(), otherColors.hashCode());
	}
	
}
