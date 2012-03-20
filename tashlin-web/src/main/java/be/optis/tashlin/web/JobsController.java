package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JobsController {

	@RequestMapping(value= {"/", "/jobs"})
	public String showJobs() {
		return ".jobs.overview";
	}

}
