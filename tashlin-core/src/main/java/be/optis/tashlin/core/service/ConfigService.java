package be.optis.tashlin.core.service;

import be.optis.tashlin.core.exception.ServiceException;
import be.optis.tashlin.core.model.Config;
import be.optis.tashlin.core.model.GlobalSettings;

public interface ConfigService {

	void save(Config config) throws ServiceException;
	
	GlobalSettings getGlobalSettings() throws ServiceException;
	
}
