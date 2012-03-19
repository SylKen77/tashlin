package be.optis.tashlin.service;

import static org.junit.Assert.assertEquals;

import java.util.Set;

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
	public void getJobs() {
		Set<Job> jobs = service.getJobs();
		assertEquals(1, jobs.size());
		assertEquals("Job1", jobs.iterator().next().getName());
	}
	
	@Test
	public void getJobById() {
		Job job = service.getJob(1L);
		assertEquals("Job1", job.getName());
	}
	
}
