package com.javadevtools.dateparse;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.threeten.extra.AmPm;
import org.threeten.extra.DayOfMonth;
import org.threeten.extra.DayOfYear;
import org.threeten.extra.OffsetDate;
import org.threeten.extra.Quarter;
import org.threeten.extra.YearQuarter;
import org.threeten.extra.YearWeek;

import com.javadevtools.dateformat.FormatterType;

@Component
public class DateTimeFormatterParseWrapper implements IDateParseWrapper {

	@Override
	public String parse(String pattern, String text, Locale locale, ZoneId timeZone) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
		
		TemporalAccessor accessor = formatter.parseBest(text,
				OffsetDateTime::from,
				ZonedDateTime::from,
				Instant::from,
				LocalDateTime::from,
				OffsetDate::from,
				LocalDate::from,
				YearMonth::from,
				YearQuarter::from,
				YearWeek::from,
				Year::from,
				MonthDay::from,
				Month::from,
				DayOfMonth::from,
				DayOfYear::from,
				DayOfWeek::from,
				OffsetTime::from,
				LocalTime::from,
				AmPm::from,
				Quarter::from,
				ZoneOffset::from);
		
		return accessor.getClass().getSimpleName() + ": " + accessor.toString();
	}

	@Override
	public FormatterType getType() {
		return FormatterType.DateTimeFormatter;
	}

}
