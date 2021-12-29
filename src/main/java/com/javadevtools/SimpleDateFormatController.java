package com.javadevtools;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SimpleDateFormatController {
	private final LocaleService localeService;
	private final JavaVersionService javaVersionService;
	private final TimeZoneService timeZoneService;
	
	public SimpleDateFormatController(
			LocaleService localeService,
			JavaVersionService javaVersionService,
			TimeZoneService timeZoneService) {
		this.localeService = localeService;
		this.javaVersionService = javaVersionService;
		this.timeZoneService = timeZoneService;
	}

	@GetMapping("/simpledateformat")
	public String main(Map<String, Object> model) {
		model.put("locales", localeService.getLocales());
		model.put("timeZones", timeZoneService.getTimeZones());
		model.put("javaVersion", javaVersionService.getJavaVersion());
		return "simpledateformat";
	}

	@GetMapping(value = "/")
	public RedirectView getPost() {
		RedirectView redirectView = new RedirectView("/simpledateformat");
		redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		return redirectView;
	}
}
