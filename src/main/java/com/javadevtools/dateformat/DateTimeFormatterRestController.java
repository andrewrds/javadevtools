package com.javadevtools.dateformat;

import org.springframework.web.bind.annotation.GetMapping;
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
	private static final int MAX_PATTERN_LENGTH = 300;

	@GetMapping("/datetimeformatter/format")
	public Map<String, Object> format(@RequestParam String pattern, @RequestParam String locale,
			@RequestParam String timeZone) {
		Map<String, Object> result = new HashMap<>();

		try {
			if (pattern.length() > MAX_PATTERN_LENGTH) {
				throw new IllegalArgumentException("Pattern length exceeds maximum allowed size");
			}

			if (pattern.isBlank()) {
				result.put("value", "Empty input");
			} else {
				Locale localeObject = Locale.forLanguageTag(locale);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, localeObject);

				Instant now = Instant.now();
				ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of(timeZone));
				String value = formatter.format(zonedDateTime);

				result.put("value", value);

			}
		} catch (IllegalArgumentException e) {
			result.put("value", e.getMessage());
			result.put("error", true);
		}
		return result;
	}
}
