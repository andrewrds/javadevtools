package com.javadevtools.dateparse;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.javadevtools.logdb.ParseLogEntry;

@Component
public class ParseService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Map<String, Object> format(String sessionId, ParseParams params, IDateParseWrapper formatter) {
        entityManager.persist(ParseLogEntry.create(
                sessionId,
                params.getPattern(),
                params.getText(),
                formatter.getType()));
        
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
