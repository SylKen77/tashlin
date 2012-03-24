package be.optis.tashlin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import be.optis.tashlin.core.model.JobSettings;
import be.optis.tashlin.core.service.JobService;

@Controller
public class JobsController {

	@Autowired private JobService jobService;
	
	@RequestMapping(value= {"/", "/jobs"}, method = RequestMethod.GET)
	public String showJobs(HttpServletRequest request) {
		List<JobSettings> jobs = jobService.getJobs();
		request.setAttribute("jobs", jobs);
		return ".job.overview";
	}
	
	@RequestMapping(value="/job/{name}/summary", method = RequestMethod.GET)
	public String showJobDetails(@PathVariable String name, HttpServletRequest request) {
		List<JobSettings> jobs = jobService.getJobs();
		request.setAttribute("jobs", jobs);
		return ".job.summary";
	}
	
	@RequestMapping(value="/job/build", method = RequestMethod.GET)
	public  @ResponseBody void build(HttpServletResponse response) throws Exception {
		jobService.triggerBuild();
		response.setContentType("application/json");
        response.getWriter().write("{\"status\": \"Build Started\"}");
	}

}
