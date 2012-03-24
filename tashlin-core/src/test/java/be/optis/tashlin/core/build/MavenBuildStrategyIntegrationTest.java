package be.optis.tashlin.core.build;

import org.junit.Before;
import org.junit.Test;

public class MavenBuildStrategyIntegrationTest {
	
	private MavenBuildStrategy buildStrategy;
	
	@Before
	public void setUp() {
		buildStrategy = new MavenBuildStrategy();
	}
	
	@Test
	public void testBuild() {
		buildStrategy.build();
	}
	
	

}
