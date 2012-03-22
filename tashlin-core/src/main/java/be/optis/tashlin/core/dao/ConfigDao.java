package be.optis.tashlin.core.dao;

import java.io.IOException;
import java.io.OutputStream;

import be.optis.tashlin.core.model.Config;

public interface ConfigDao {

	void save(Config config) throws IOException;
	
	void save(Config config, OutputStream os) throws IOException;

	Config getConfig() throws IOException;
	
}
