package com.javadevtools.dateparse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.javadevtools.dateformat.FormatterType;

@Component
public class SimpleDateFormatParseWrapper implements IDateParseWrapper {

    @Override
    public String parse(String pattern, String text, Locale locale, ZoneId zoneId) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
        TimeZone timeZoneObject = TimeZone.getTimeZone(zoneId);
        formatter.setTimeZone(timeZoneObject);
        
        Instant instant = formatter.parse(text).toInstant();
        ZonedDateTime dateTime = ZonedDateTime.ofInstant(instant, zoneId);
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateTime);
    }

    @Override
    public FormatterType getType() {
        return FormatterType.SimpleDateFormat;
    }

}
