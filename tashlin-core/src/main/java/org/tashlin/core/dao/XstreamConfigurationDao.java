package org.tashlin.core.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.model.JobDefinition;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class XstreamConfigurationDao implements ConfigurationDao {

	private XStream xstream;

	public XstreamConfigurationDao() {
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("tashlin", Configuration.class);  
		xstream.alias("job", JobDefinition.class);  
		xstream.alias("globalSettings", GlobalSettings.class);
	}
	
	public void save(File configFile, Configuration configuration) throws IOException {
		xstream.toXML(configuration, new FileOutputStream(configFile));
	}
	
	public Configuration getConfiguration(File configFile) throws IOException {
		if(!configFile.exists()) {
			configFile.getParentFile().mkdirs();
			save(configFile, new Configuration());
		}
		return (Configuration) xstream.fromXML(new FileInputStream(configFile));
	}
	
}
