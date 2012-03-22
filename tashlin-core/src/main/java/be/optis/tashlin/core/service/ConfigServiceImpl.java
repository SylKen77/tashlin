package be.optis.tashlin.core.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.optis.tashlin.core.dao.ConfigDao;
import be.optis.tashlin.core.exception.ServiceException;
import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.GlobalSettings;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired private ConfigDao configDao;
	
	public void save(Config config) {
		try {
			configDao.save(config);
		} catch (IOException e) {
			throw new ServiceException();
		}
	}

	public GlobalSettings getGlobalSettings() {
		try {
			Config config = configDao.getConfig();
			if(config == null) {
				config = new Config();
			}	
			return config.getGlobalSettings();
		} catch (IOException e) {
			throw new ServiceException();
		}
	}
	
}
