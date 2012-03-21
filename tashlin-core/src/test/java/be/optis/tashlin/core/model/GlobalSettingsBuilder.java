package be.optis.tashlin.core.model;

public class GlobalSettingsBuilder {

	private GlobalSettings globalSettings;
	
	public GlobalSettingsBuilder mock() {
		globalSettings = new GlobalSettings();
		return this;
	}
	
	public GlobalSettings andReturn() {
		return globalSettings;
	}
	
}
