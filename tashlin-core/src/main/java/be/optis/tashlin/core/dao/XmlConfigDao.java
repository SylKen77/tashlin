package be.optis.tashlin.core.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Repository;

import be.optis.tashlin.core.model.Config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class XmlConfigDao implements ConfigDao {
	
	private XStream xstream;
	private String xmlFile;
	
	public XmlConfigDao(String xmlFile) {
		this.xmlFile = xmlFile;
		
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("tashlin", Config.class);  
	}

	public void save(Config config) throws IOException {		
		save(config, new FileOutputStream(xmlFile));
	}
	
	public void save(Config config, OutputStream os) throws IOException {
		xstream.toXML(config, os);
	}
	
	public Config getConfig() throws IOException {
		return (Config) xstream.fromXML(new FileInputStream(xmlFile));
	}

}
