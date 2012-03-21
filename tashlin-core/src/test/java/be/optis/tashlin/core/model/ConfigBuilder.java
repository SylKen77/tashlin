package be.optis.tashlin.core.model;

public class ConfigBuilder {

	private Config config;
	
	private GlobalSettingsBuilder globalSettingsBuilder;
	
	public ConfigBuilder() {
		globalSettingsBuilder = new GlobalSettingsBuilder();
	}
	
	public ConfigBuilder mock() {
		config = new Config();
		config.setGlobalSettings(globalSettingsBuilder.mock().andReturn());
		return this;
	}
	
	public Config andReturn() {
		return config;
	}
	
}
