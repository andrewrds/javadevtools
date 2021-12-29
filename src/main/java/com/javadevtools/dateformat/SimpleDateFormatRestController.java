package com.javadevtools.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleDateFormatRestController {

	@GetMapping("/simpledateformat/format")
	public Map<String, Object> format(@Valid DateFormatParams params) {
		Map<String, Object> result = new HashMap<>();

		String locale = params.getLocale();
		int colonIndex = locale.indexOf(':');
		if (colonIndex != -1) {
			locale = locale.substring(0, colonIndex);
		}

		Locale localeObject = Locale.forLanguageTag(locale);
		SimpleDateFormat formatter = new SimpleDateFormat(params.getPattern(), localeObject);

		TimeZone timeZoneObject = TimeZone.getTimeZone(params.getTimeZone());
		formatter.setTimeZone(timeZoneObject);

		String value = formatter.format(new Date());
		result.put("value", value);

		return result;
	}
}
