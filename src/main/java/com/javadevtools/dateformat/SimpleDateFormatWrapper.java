package com.javadevtools.dateformat;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

@Component
public class SimpleDateFormatWrapper implements IDateFormatterWrapper {
    private final Clock clock;
    
    public SimpleDateFormatWrapper(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String format(String pattern, Locale locale, String timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
        
        TimeZone timeZoneObject = TimeZone.getTimeZone(timeZone);
        formatter.setTimeZone(timeZoneObject);
        return formatter.format(Date.from(Instant.now(clock)));
    }

    @Override
    public FormatterType getType() {
        return FormatterType.SimpleDateFormat;
    }

}
