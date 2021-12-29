package com.javadevtools.dateformat;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeFormatterRestController {

	@GetMapping("/datetimeformatter/format")
	public Map<String, Object> format(@Valid DateFormatParams params) {
		Map<String, Object> result = new HashMap<>();

		String locale = params.getLocale();
		int colonIndex = locale.indexOf(':');
		if (colonIndex != -1) {
			locale = locale.substring(0, colonIndex);
		}

		Locale localeObject = Locale.forLanguageTag(locale);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(params.getPattern(), localeObject);

		Instant now = Instant.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of(params.getTimeZone()));
		String value = formatter.format(zonedDateTime);

		result.put("value", value);

		return result;
	}
}
