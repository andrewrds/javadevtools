package com.javadevtools.dateformat;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javadevtools.system.JavaVersionService;
import com.javadevtools.system.LocaleService;
import com.javadevtools.system.TimeZoneService;

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
		populateModel(model);
		return "simpledateformat";
	}

	@GetMapping("/datetimeformatter")
	public String displayDateTimeFormatterPage(Map<String, Object> model) {
		populateModel(model);
		return "datetimeformatter";
	}
	
	private void populateModel(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
	}
}
