package com.javadevtools.dateformat;

import java.util.Locale;

public interface IDateFormatterWrapper {
    public String format(String pattern, Locale locale, String timeZone);
    
    public FormatterType getType();
}
