package be.optis.tashlin.core.domain;

public class Job {

	private Long id;
	private String name;

	public Job(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
