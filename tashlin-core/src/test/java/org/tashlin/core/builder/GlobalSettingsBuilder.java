package org.tashlin.core.builder;

import org.tashlin.core.model.Colors;
import org.tashlin.core.model.GlobalSettings;

public class GlobalSettingsBuilder {

	private GlobalSettings globalSettings;
	
	public GlobalSettingsBuilder mock() {
		globalSettings = new GlobalSettings();
		globalSettings.setMavenHome("D:/DEV/maven/bin");
		globalSettings.setColors(new Colors());
		return this;
	}
	
	public GlobalSettings build() {
		return globalSettings;
	}
	
}
