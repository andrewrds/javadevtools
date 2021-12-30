package com.javadevtools.dateformat;

import java.util.Locale;

@FunctionalInterface
public interface IDateFormatterWrapper {
	public String format(String pattern, Locale locale, String timeZone);
}
