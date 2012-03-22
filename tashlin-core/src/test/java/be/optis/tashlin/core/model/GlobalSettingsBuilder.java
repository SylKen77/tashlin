package be.optis.tashlin.core.model;

public class GlobalSettingsBuilder {

	private GlobalSettings globalSettings;
	
	private ColorsBuilder colorsBuilder;

	public GlobalSettingsBuilder() {
		colorsBuilder = new ColorsBuilder();
	}
	
	public GlobalSettingsBuilder mock() {
		globalSettings = new GlobalSettings();
		globalSettings.setColors(colorsBuilder.mock().andReturn());
		return this;
	}
	
	public GlobalSettingsBuilder initialMock() {
		globalSettings = new GlobalSettings();
		return this;
	}
	
	public GlobalSettings andReturn() {
		return globalSettings;
	}
	
}
