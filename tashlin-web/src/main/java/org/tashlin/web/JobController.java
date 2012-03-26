package org.tashlin.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tashlin.core.service.JobService;

@Controller
public class JobController {

	@Autowired private JobService jobService;

	@RequestMapping(value= {"/", "/jobs"}, method = RequestMethod.GET)
	public String showJobs(HttpServletRequest request) {
		request.setAttribute("jobs", jobService.getJobs());
		return ".job.overview";
	}

	@RequestMapping(value="/job/{name}/summary", method = RequestMethod.GET)
	public String showJobSummary(HttpServletRequest request, @PathVariable String name) {
		request.setAttribute("job", jobService.getJob(name));
		return ".job.summary";
	}

	@RequestMapping(value="/job/{name}/schedule", method = RequestMethod.GET)
	public void schedule(HttpServletRequest request, @PathVariable String name) {
		jobService.schedule(name);
	}
	
	@RequestMapping(value="/job/{name}/status", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getStatus(@PathVariable String name) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("status", jobService.getStatus(name));
		return map;
	}

}
