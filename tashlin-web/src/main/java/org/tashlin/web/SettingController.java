package org.tashlin.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tashlin.core.model.GlobalSettings;
import org.tashlin.core.service.SettingService;

@Controller
@RequestMapping(value="/settings")
public class SettingController {

	@Autowired private SettingService settingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showSettings(HttpServletRequest request) {
		request.setAttribute("globalSettings", settingService.getSettings());
		return ".settings.overview";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid GlobalSettings globalSettings, BindingResult result) {
		if(result.hasErrors()) {
			return ".settings.overview";
		}
		settingService.save(globalSettings);
		return "redirect:/jobs";
	}

	@RequestMapping(value="/reload", method = RequestMethod.GET)
	public String reloadConfiguration() {
		settingService.reloadConfiguration();
		return "redirect:/jobs";
	}

}
