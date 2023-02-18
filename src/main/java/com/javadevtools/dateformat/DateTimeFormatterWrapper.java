package com.javadevtools.dateformat;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DateTimeFormatterWrapper implements IDateFormatterWrapper {
    private final Clock clock;
    
    public DateTimeFormatterWrapper(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String format(String pattern, Locale locale, String timeZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        
        Instant now = Instant.now(clock);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of(timeZone));
        return formatter.format(zonedDateTime);
    }

    @Override
    public FormatterType getType() {
        return FormatterType.DateTimeFormatter;
    }

}
