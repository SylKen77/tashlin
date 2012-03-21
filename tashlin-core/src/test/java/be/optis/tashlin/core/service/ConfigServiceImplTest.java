package be.optis.tashlin.core.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import be.optis.tashlin.core.dao.ConfigDao;
import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.test.AbstractUnitTest;
import static org.mockito.Mockito.verify;

public class ConfigServiceImplTest extends AbstractUnitTest {

	private ConfigServiceImpl service;
	@Mock private ConfigDao configDao;
	
	@Before
	public void setUp() {
		service = new ConfigServiceImpl();
		ReflectionTestUtils.setField(service, "configDao", configDao);
	}
	
	@Test
	public void save() {
		Config config = new Config();
		service.save(config);
		verify(configDao).save(config);
	}
	
}
