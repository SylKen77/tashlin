package org.tashlin.core.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.tashlin.core.model.Configuration;
import org.tashlin.core.model.JobDefinition;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class XmlConfigurationDao implements ConfigurationDao {

	private XStream xstream;
	private File source;
	
	public XmlConfigurationDao(@Qualifier("xmlConfig") File source) {
		this.source = source;
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("tashlin", Configuration.class);  
		xstream.alias("job", JobDefinition.class);  
	}
	
	public void save(Configuration configuration) throws IOException {
		xstream.toXML(configuration, new FileOutputStream(source));
	}
	
	public Configuration getConfiguration() throws IOException {
		return (Configuration) xstream.fromXML(new FileInputStream(source));
	}

}
