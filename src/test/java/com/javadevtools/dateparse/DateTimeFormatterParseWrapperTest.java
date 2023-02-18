package com.javadevtools.dateparse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZoneId;
import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.javadevtools.dateformat.FormatterType;

class DateTimeFormatterParseWrapperTest {
    
    private static DateTimeFormatterParseWrapper wrapper;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        wrapper = new DateTimeFormatterParseWrapper();
    }

    @Test
    void testParse() {
        assertEquals(
                "LocalDateTime: 2021-04-23T14:55:22",
                wrapper.parse("yyyy-MM-dd HHmmss", "2021-04-23 145522", Locale.US, ZoneId.of("America/New_York")));
        
        assertEquals(
                "DayOfMonth:25",
                wrapper.parse("dd", "25", Locale.US, ZoneId.of("America/New_York")));        
    }

    @Test
    void testGetType() {
        assertEquals(FormatterType.DateTimeFormatter, wrapper.getType());
    }

}
