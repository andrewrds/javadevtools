package com.javadevtools.dateformat;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DateTimeFormatterWrapper implements IDateFormatterWrapper {

	@Override
	public String format(String pattern, Locale locale, String timeZone) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
		
		Instant now = Instant.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of(timeZone));
		return formatter.format(zonedDateTime);
	}

}