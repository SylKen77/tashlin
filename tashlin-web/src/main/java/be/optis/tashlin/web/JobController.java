package be.optis.tashlin.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.optis.tashlin.core.domain.Job;
import be.optis.tashlin.core.service.JobService;


@Controller
public class JobController {

	@Autowired private JobService jobService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showJobs(HttpServletRequest request) {
		Set<Job> jobs = jobService.getJobs();
		if(!jobs.isEmpty()) {
			request.setAttribute("jobs", jobService.getJobs());
		}
		return ".jobs.overview";
	}
	
	@RequestMapping(value="/jobs/{id}", method = RequestMethod.GET)
	public String showJobDetail(HttpServletRequest request, Long id) {
		request.setAttribute("job", jobService.getJob(1L));
		return ".jobs.detail";
	}
	
	@RequestMapping(value="/jobs/{id}", method = RequestMethod.POST)
	public String runBuild() {
		return ".jobs.detail";
	}
	
}
