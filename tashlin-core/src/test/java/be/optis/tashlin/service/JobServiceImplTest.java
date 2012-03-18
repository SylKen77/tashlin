package be.optis.tashlin.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.optis.tashlin.core.domain.Job;
import be.optis.tashlin.core.service.JobServiceImpl;

public class JobServiceImplTest {

	private JobServiceImpl service;
	
	@Before
	public void setUp() {
		service = new JobServiceImpl();
	}
	
	@Test
	public void testGetJobs() {
		List<Job> jobs = service.getJobs();
		assertEquals(1, jobs.size());
		assertEquals("Job1", jobs.get(0).getName());
	}
	
}
