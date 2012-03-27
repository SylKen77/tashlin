package org.tashlin.core.service;

import org.tashlin.core.model.GlobalSettings;

public interface SettingService {

	GlobalSettings getSettings();
	
	void save(GlobalSettings globalSettings);
	
}
