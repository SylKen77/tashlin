package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PluginsController {

	@RequestMapping(value= "/plugins")
	public String showPlugins() {
		return ".plugins.overview";
	}

}
