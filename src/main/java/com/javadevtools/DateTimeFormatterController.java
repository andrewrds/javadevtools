package com.javadevtools;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class DateTimeFormatterController {
	@Autowired
	private LocaleService localeService;

	@Autowired
	private JavaVersionService javaVersionService;
	
	@Autowired
	private TimeZoneService timeZoneService;

	@RequestMapping("/datetimeformatter")
	public String main(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
		return "datetimeformatter";
	}
}
