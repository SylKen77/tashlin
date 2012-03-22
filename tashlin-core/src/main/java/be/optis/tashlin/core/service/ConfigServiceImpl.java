package be.optis.tashlin.core.service;

import java.io.IOException;

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
		try {
			configDao.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GlobalSettings getGlobalSettings() {
		Config config;
		try {
			config = configDao.getConfig();
		
		if(config == null) {
			config = new Config();
			
			GlobalSettings globalSettings = new GlobalSettings();
			config.setGlobalSettings(globalSettings);
			
			Colors colors = new Colors();
			colors.setSuccess("#333333");
			globalSettings.setColors(colors);
		}
		
		return config.getGlobalSettings();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
