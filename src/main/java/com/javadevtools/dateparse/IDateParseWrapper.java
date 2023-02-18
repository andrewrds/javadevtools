package com.javadevtools.dateparse;

import java.text.ParseException;
import java.time.ZoneId;
import java.util.Locale;

import com.javadevtools.dateformat.FormatterType;

public interface IDateParseWrapper {
    public String parse(String pattern, String text, Locale locale, ZoneId timeZone) throws ParseException;
    
    public FormatterType getType();
}
