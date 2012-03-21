package be.optis.tashlin.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.optis.tashlin.core.dao.ConfigDao;
import be.optis.tashlin.core.model.Colors;
import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.GlobalSettings;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired private ConfigDao configDao;
	
	public void save(Config config) {
		configDao.save(config);
	}

	public GlobalSettings getGlobalSettings() {
		Config config = configDao.getConfig();
		if(config == null) {
			config = new Config();
			
			GlobalSettings globalSettings = new GlobalSettings();
			config.setGlobalSettings(globalSettings);
			
			Colors colors = new Colors();
			colors.setSuccess("#333333");
			globalSettings.setColors(colors);
		}
		return config.getGlobalSettings();
	}
	
}
