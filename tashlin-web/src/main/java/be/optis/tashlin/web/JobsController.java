package be.optis.tashlin.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import be.optis.tashlin.core.service.JobService;


@Controller
@RequestMapping(value= {"/", "/jobs"})
public class JobsController {

	@Autowired private JobService jobService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showJobs() {
		return ".jobs.overview";
	}
	
	@RequestMapping(value="/build", method = RequestMethod.GET)
	public  @ResponseBody void build(HttpServletResponse response) throws Exception {
		jobService.triggerBuild();
		response.setContentType("application/json");
        response.getWriter().write("{\"status\": \"Build Started\"}");
	}

}
