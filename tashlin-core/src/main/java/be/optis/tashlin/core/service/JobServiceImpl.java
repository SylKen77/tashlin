package be.optis.tashlin.core.service;

import java.util.ArrayList;
import java.util.List;

import be.optis.tashlin.core.domain.Job;

public class JobServiceImpl implements JobService {

	public List<Job> getJobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job("Job1"));
		return jobs;
	}

}
