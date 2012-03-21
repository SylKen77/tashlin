package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value= "/plugins")
public class PluginsController {

	public String showPlugins() {
		return ".plugins.overview";
	}

}
