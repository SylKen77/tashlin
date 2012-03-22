package be.optis.tashlin.core.dao;

import java.io.IOException;

import be.optis.tashlin.core.model.Config;

public interface ConfigDao {

	void save(Config config) throws IOException;
	
	Config getConfig() throws IOException;
	
}
