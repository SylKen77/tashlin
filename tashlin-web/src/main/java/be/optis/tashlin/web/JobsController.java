package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JobsController {

	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public String view() {
		return ".jobs";
	}
	
}
