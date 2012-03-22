package be.optis.tashlin.core.model;

public class ColorsBuilder {

	private Colors colors;
	
	public ColorsBuilder mock() {
		colors = new Colors();
		colors.setSuccess("#458B00");
		return this;
	}
	
	public Colors andReturn() {
		return colors;
	}
	
}
