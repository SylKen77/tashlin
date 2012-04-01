package org.tashlin.core.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.model.JobDefinition;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class XmlConfigurationDao implements ConfigurationDao {

	private XStream xstream;
	private File source;
	
	@Autowired
	public XmlConfigurationDao(@Qualifier("xmlConfig") File source) {
		this.source = source;
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("tashlin", Configuration.class);  
		xstream.alias("job", JobDefinition.class);  
		xstream.alias("globalSettings", GlobalSettings.class);
	}
	
	public void save(Configuration configuration) throws IOException {
		xstream.toXML(configuration, new FileOutputStream(source));
	}
	
	public Configuration getConfiguration() throws IOException {
		if(!source.exists()) {
			source.getParentFile().mkdir();
			source.createNewFile();
			InputStream cleanConfig = this.getClass().getClassLoader().getResourceAsStream("clean-config.xml");
			OutputStream os = new FileOutputStream(source);
			IOUtils.copy(cleanConfig, os);	
		}
		return (Configuration) xstream.fromXML(new FileInputStream(source));
	}

}
