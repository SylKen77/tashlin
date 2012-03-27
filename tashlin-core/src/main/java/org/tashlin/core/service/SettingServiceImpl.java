package org.tashlin.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tashlin.core.model.GlobalSettings;

@Service
public class SettingServiceImpl implements SettingService {

	@Autowired private ConfigurationService configurationService;
	
	public GlobalSettings getSettings() {
		return configurationService.getGlobalSettings();
	}

	public void save(GlobalSettings globalSettings) {
		configurationService.save(globalSettings);
	}

}
