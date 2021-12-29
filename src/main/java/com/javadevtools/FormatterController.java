package com.javadevtools;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormatterController {
	private final LocaleService localeService;
	private final JavaVersionService javaVersionService;
	private final TimeZoneService timeZoneService;
	
	public FormatterController(
			LocaleService localeService,
			JavaVersionService javaVersionService,
			TimeZoneService timeZoneService) {
		this.localeService = localeService;
		this.javaVersionService = javaVersionService;
		this.timeZoneService = timeZoneService;
	}
	
	@GetMapping("/simpledateformat")
	public String displaySimpleDateFormatPage(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
		return "simpledateformat";
	}

	@GetMapping("/datetimeformatter")
	public String displayDateTimeFormatterPage(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
		return "datetimeformatter";
	}
}
