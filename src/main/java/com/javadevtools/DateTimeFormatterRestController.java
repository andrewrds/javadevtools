package com.javadevtools;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class DateTimeFormatterRestController {

	@RequestMapping("/datetimeformatter/format")
	public Map<String, Object> format(
			@RequestParam String pattern,
			@RequestParam String locale,
			@RequestParam String timeZone) {
		Map<String, Object> result = new HashMap<>();

		if (pattern.isBlank()) {
			result.put("value", "Empty input");
		} else {
			try {
				Locale localeObject = Locale.forLanguageTag(locale);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, localeObject);
				
				Instant now = Instant.now();
				ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of(timeZone));
				String value = formatter.format(zonedDateTime);

				result.put("value", value);
			} catch (IllegalArgumentException e) {
				result.put("value", e.getMessage());
				result.put("error", true);
			}
		}

		return result;
	}
}
