package org.tashlin.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import org.tashlin.core.model.JobDefinition;
import org.tashlin.core.service.JobService;

@Controller
public class JobController {

	@Autowired private JobService jobService;

	@RequestMapping(value= {"/", "/jobs"}, method = RequestMethod.GET)
	public String showJobs(HttpServletRequest request) {
		request.setAttribute("jobs", jobService.getJobs());
		return ".job.overview";
	}
	
	@RequestMapping(value="/jobs/add", method = RequestMethod.GET)
	public String addJob(HttpServletRequest request) {
		request.setAttribute("job", new JobDefinition());
		return ".job.add";
	}
	
	@RequestMapping(value="/jobs/add", method = RequestMethod.POST)
	public RedirectView saveJob(JobDefinition job) {
		jobService.save(job);
		return new RedirectView("/jobs", true);
	}
	
	@RequestMapping(value="/job/{key}/delete", method = RequestMethod.GET)
	public RedirectView deleteJob(@PathVariable String key) {
		jobService.delete(key);
		return new RedirectView("/jobs", true);
	}

	@RequestMapping(value="/job/{key}/summary", method = RequestMethod.GET)
	public String showJobSummary(HttpServletRequest request, @PathVariable String key) {
		request.setAttribute("job", jobService.getJob(key));
		return ".job.summary";
	}

	@RequestMapping(value="/job/{key}/schedule", method = RequestMethod.GET)
	public void schedule(HttpServletRequest request, @PathVariable String key) {
		jobService.schedule(key);
	}
	
	@RequestMapping(value="/job/{key}/status", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getStatus(@PathVariable String key) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("status", jobService.getStatus(key));
		return map;
	}

}
