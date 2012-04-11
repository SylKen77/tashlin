package org.tashlin.core.dao;

import java.io.File;
import java.io.IOException;

import org.tashlin.core.model.Configuration;

public interface ConfigurationDao {

	void save(File configFile, Configuration configuration) throws IOException;
	
	Configuration getConfiguration(File configFile) throws IOException;
	
}
