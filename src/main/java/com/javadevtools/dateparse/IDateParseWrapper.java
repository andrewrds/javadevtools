package com.javadevtools.dateparse;

import java.text.ParseException;
import java.time.ZoneId;
import java.util.Locale;

@FunctionalInterface
public interface IDateParseWrapper {
	public String parse(String pattern, String text, Locale locale, ZoneId timeZone) throws ParseException;
}
