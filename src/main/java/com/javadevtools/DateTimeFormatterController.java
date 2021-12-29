package com.javadevtools;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeFormatterController {
	private final LocaleService localeService;
	private final JavaVersionService javaVersionService;
	private final TimeZoneService timeZoneService;
	
	public DateTimeFormatterController(
			LocaleService localeService,
			JavaVersionService javaVersionService,
			TimeZoneService timeZoneService) {
		this.localeService = localeService;
		this.javaVersionService = javaVersionService;
		this.timeZoneService = timeZoneService;
	}

	@GetMapping("/datetimeformatter")
	public String main(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
		return "datetimeformatter";
	}
}
