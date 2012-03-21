package be.optis.tashlin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.optis.tashlin.core.model.Colors;
import be.optis.tashlin.core.model.GlobalSettings;
import be.optis.tashlin.core.service.ConfigService;


@Controller
@RequestMapping(value= "/settings")
public class SettingsController {

	@Autowired private ConfigService configService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showSettings(HttpServletRequest request) {
		request.setAttribute("settings", configService.getGlobalSettings());
		return ".settings.overview";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute GlobalSettings settings) {
		System.out.println("//" + settings.getColors().getSuccess());
		return "redirect:/jobs";
	}

}
