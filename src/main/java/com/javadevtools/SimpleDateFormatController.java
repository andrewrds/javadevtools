package com.javadevtools;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SimpleDateFormatController {
	@Autowired
	private LocaleService localeService;

	@Autowired
	private JavaVersionService javaVersionService;
	
	@Autowired
	private TimeZoneService timeZoneService;

	@GetMapping("/simpledateformat")
	public String main(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
		return "simpledateformat";
	}
}
