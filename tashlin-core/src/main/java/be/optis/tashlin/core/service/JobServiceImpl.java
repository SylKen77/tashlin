package be.optis.tashlin.core.service;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import be.optis.tashlin.core.domain.Job;

@Service
public class JobServiceImpl implements JobService {

	private Map<Long, Job> jobs;
	
	public JobServiceImpl() {
		jobs = new HashMap<Long, Job>();
		jobs.put(1L, new Job(1L, "Job1"));
	}
	
	public Set<Job> getJobs() {
		return new LinkedHashSet<Job>(jobs.values());
	}

	public Job getJob(Long id) {
		return jobs.get(id);
	}

}
