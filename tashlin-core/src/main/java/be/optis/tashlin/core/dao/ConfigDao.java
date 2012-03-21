package be.optis.tashlin.core.dao;

import org.springframework.stereotype.Repository;

import be.optis.tashlin.core.model.Config;

public interface ConfigDao {

	void save(Config config);
	
	Config getConfig();
	
}
