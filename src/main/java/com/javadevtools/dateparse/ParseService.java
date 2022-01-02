package com.javadevtools.dateparse;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ParseService {

	public Map<String, Object> format(ParseParams params, IDateParseWrapper formatter) {
		Map<String, Object> result = new HashMap<>();

		try {
			Locale locale = new Locale.Builder().setLanguageTag(params.getLocale()).build();
			String value = formatter.parse(params.getPattern(), params.getText(), locale, params.getTimeZone());
			result.put("value", value);
		} catch (RuntimeException | ParseException e) {
			result.put("value", e.getMessage());
			result.put("error", true);
		}

		return result;
	}
}
