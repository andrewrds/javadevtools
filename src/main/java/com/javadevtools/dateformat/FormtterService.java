package com.javadevtools.dateformat;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FormtterService {

	public Map<String, Object> format(DateFormatParams params, IDateFormatterWrapper formatter) {
		Map<String, Object> result = new HashMap<>();

		try {
			Locale locale = Locale.forLanguageTag(params.getLocale());
			String value = formatter.format(params.getPattern(), locale, params.getTimeZone());
			result.put("value", value);
		} catch (RuntimeException e) {
			result.put("value", e.getMessage());
			result.put("error", true);
		}

		return result;
	}
}
