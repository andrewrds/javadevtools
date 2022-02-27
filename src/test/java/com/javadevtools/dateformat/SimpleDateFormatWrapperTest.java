package com.javadevtools.dateformat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SimpleDateFormatWrapperTest {
	private static SimpleDateFormatWrapper wrapper;
	
	@BeforeAll
	public static void setUpBeforeClass() {
		ZoneId zoneId = ZoneId.of("America/New_York");
		Clock clock = Clock.fixed(ZonedDateTime.of(2022, 11, 28, 13, 44, 55, 0, zoneId).toInstant(), zoneId);
		wrapper = new SimpleDateFormatWrapper(clock);
	}

	@Test
	void testFormat() {
		assertEquals("", wrapper.format("", Locale.US, "America/New_York"));
		assertEquals("2022-November-28 134455", wrapper.format("yyyy-MMMM-dd HHmmss", Locale.US, "America/New_York"));
		assertEquals("2022-novembre-28 134455", wrapper.format("yyyy-MMMM-dd HHmmss", Locale.FRANCE, "America/New_York"));
		assertEquals("2022-November-28 194455", wrapper.format("yyyy-MMMM-dd HHmmss", Locale.US, "Europe/Warsaw"));
	}

	@Test
	void testGetType() {
		assertEquals(FormatterType.SimpleDateFormat, wrapper.getType());
	}

}
