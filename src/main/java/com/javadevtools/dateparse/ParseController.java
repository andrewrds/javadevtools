package com.javadevtools.dateparse;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javadevtools.system.JavaVersionService;
import com.javadevtools.system.LocaleService;
import com.javadevtools.system.TimeZoneService;

@Controller
public class ParseController {
	private final LocaleService localeService;
	private final JavaVersionService javaVersionService;
	private final TimeZoneService timeZoneService;
	
	public ParseController(
			LocaleService localeService,
			JavaVersionService javaVersionService,
			TimeZoneService timeZoneService) {
		this.localeService = localeService;
		this.javaVersionService = javaVersionService;
		this.timeZoneService = timeZoneService;
	}
	
	@GetMapping("/simpledateformatparse")
	public String displaySimpleDateFormatPage(Map<String, Object> model) {
		populateModel(model);
		return "simpledateformatparse";
	}

	@GetMapping("/datetimeformatterparse")
	public String displayDateTimeFormatterPage(Map<String, Object> model) {
		populateModel(model);
		return "datetimeformatterparse";
	}
	
	private void populateModel(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
	}
}
