package com.javadevtools.dateformat;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.javadevtools.logdb.FormatLogEntry;

@Component
public class FormtterService {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Map<String, Object> format(String sessionId, DateFormatParams params, IDateFormatterWrapper formatter) {
		entityManager.persist(FormatLogEntry.create(
				sessionId,
				params.getPattern(),
				formatter.getType()));
		
		Map<String, Object> result = new HashMap<>();

		try {
			Locale locale = new Locale.Builder().setLanguageTag(params.getLocale()).build();
			String value = formatter.format(params.getPattern(), locale, params.getTimeZone());
			result.put("value", value);
		} catch (RuntimeException e) {
			result.put("value", e.getMessage());
			result.put("error", true);
		}

		return result;
	}
}
