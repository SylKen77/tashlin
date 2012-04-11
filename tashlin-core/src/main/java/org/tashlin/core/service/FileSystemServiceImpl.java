package org.tashlin.core.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class FileSystemServiceImpl implements FileSystemService {

	protected static final String TASHLIN_HOME = "TASHLIN_HOME";
	
	private String getTashlinHome() {
		return System.getProperty(TASHLIN_HOME, System.getProperty("user.home") + "/.tashlin");
	}
	
	public File getConfigFile() {
		return new File(getTashlinHome() + "/config.xml");
	}

}
