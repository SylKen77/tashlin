package be.optis.tashlin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.optis.tashlin.core.service.JobService;


@Controller
public class JobController {

	@Autowired private JobService jobService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String view(HttpServletRequest request) {
		request.setAttribute("jobs", jobService.getJobs());
		return ".jobs";
	}
	
}
