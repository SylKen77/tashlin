package org.tashlin.core.service;

import java.io.File;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

public class FileSystemServiceImplTest {

	private FileSystemServiceImpl service;
	@Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Before
	public void setUp() {
		service = new FileSystemServiceImpl();
	}
	
	@Test
	public void testGetConfigFile() {
		assertEquals(new File(System.getProperty("user.home") + "/.tashlin/config.xml"), service.getConfigFile());
	}
	
	@Test
	public void testGetConfigFileWhenTashlinHomeSet() {
		System.setProperty(FileSystemServiceImpl.TASHLIN_HOME, temporaryFolder.getRoot().toString());
		assertEquals(new File(System.getProperty(FileSystemServiceImpl.TASHLIN_HOME) + "/config.xml"), service.getConfigFile());
	}
	
}
