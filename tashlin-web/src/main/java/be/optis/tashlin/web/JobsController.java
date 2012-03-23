package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value= {"/", "/jobs"})
public class JobsController {

	@RequestMapping(method = RequestMethod.GET)
	public String showJobs() {
		return ".jobs.overview";
	}

}
