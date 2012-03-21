package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/views")
public class ViewsController {

	public String showViews() {
		return ".views.overview";
	}

}
