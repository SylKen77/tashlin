package be.optis.tashlin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SettingsController {

	@RequestMapping(value= "/settings")
	public String showSettings() {
		return ".settings.overview";
	}
	
	@RequestMapping(value="/settings", method = RequestMethod.POST)
	public String save() {
		return ".settings.overview";
	}

}
