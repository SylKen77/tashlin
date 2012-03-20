package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewsController {

	@RequestMapping(value = "/views")
	public String showViews() {
		return ".views.overview";
	}

}
