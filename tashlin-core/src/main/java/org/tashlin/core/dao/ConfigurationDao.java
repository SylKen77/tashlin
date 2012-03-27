package org.tashlin.core.dao;

import java.io.IOException;

import org.tashlin.core.model.Configuration;

public interface ConfigurationDao {

	void save(Configuration configuration) throws IOException;
	
	Configuration getConfiguration() throws IOException;
	
}
