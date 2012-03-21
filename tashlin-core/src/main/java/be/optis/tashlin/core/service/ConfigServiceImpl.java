package be.optis.tashlin.core.service;

import org.springframework.beans.factory.annotation.Autowired;

import be.optis.tashlin.core.dao.ConfigDao;
import be.optis.tashlin.core.model.Config;

public class ConfigServiceImpl implements ConfigService {

	@Autowired private ConfigDao configDao;
	
	public void save(Config config) {
		configDao.save(config);
	}
	
}
