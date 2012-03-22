package be.optis.tashlin.core.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import be.optis.tashlin.core.model.Config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Repository
public class XmlConfigDao implements ConfigDao {
	
	private XStream xstream;
	private File xmlFile;
	
	public XmlConfigDao(File xmlFile) {
		this.xmlFile = xmlFile;
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("tashlin", Config.class);  
	}
	
	public void save(Config config) throws IOException {		
		xstream.toXML(config, new FileOutputStream(xmlFile));
	}
		
	public Config getConfig() throws IOException {
		return (Config) xstream.fromXML(new FileInputStream(xmlFile));
	}

}
