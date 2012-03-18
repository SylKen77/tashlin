package be.optis.tashlin.test;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class AbstractUnitTest {

	@Before
	public final void init() {
		MockitoAnnotations.initMocks(this);
	}
	
}
