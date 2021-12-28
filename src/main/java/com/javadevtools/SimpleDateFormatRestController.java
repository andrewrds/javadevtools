package com.javadevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

@RestController
public class SimpleDateFormatRestController {
	private static final int MAX_PATTERN_LENGTH = 300;

	@GetMapping("/simpledateformat/format")
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
				int colonIndex = locale.indexOf(':');
				if (colonIndex != -1) {
					locale = locale.substring(0, colonIndex);
				}
				
				Locale localeObject = Locale.forLanguageTag(locale);
				SimpleDateFormat formatter = new SimpleDateFormat(pattern, localeObject);

				TimeZone timeZoneObject = TimeZone.getTimeZone(timeZone);
				formatter.setTimeZone(timeZoneObject);

				String value = formatter.format(new Date());

				result.put("value", value);
			}
		} catch (IllegalArgumentException e) {
			result.put("value", e.getMessage());
			result.put("error", true);
		}

		return result;
	}
}
