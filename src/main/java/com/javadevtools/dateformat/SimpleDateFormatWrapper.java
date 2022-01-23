package com.javadevtools.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

@Component
public class SimpleDateFormatWrapper implements IDateFormatterWrapper {

	@Override
	public String format(String pattern, Locale locale, String timeZone) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
		
		TimeZone timeZoneObject = TimeZone.getTimeZone(timeZone);
		formatter.setTimeZone(timeZoneObject);
		return formatter.format(new Date());
	}

	@Override
	public FormatterType getType() {
		return FormatterType.SimpleDateFormat;
	}

}
