package org.tashlin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
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
	public RedirectView save(@ModelAttribute GlobalSettings globalSettings) {
		settingService.save(globalSettings);
		return new RedirectView("/jobs", true);
	}

}
