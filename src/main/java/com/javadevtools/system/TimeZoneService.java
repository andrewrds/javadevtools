package com.javadevtools.system;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class TimeZoneService {
    private final List<TimeZone> timeZones;
    
    public TimeZoneService() {
    	timeZones = Arrays.stream(TimeZone.getAvailableIDs())
    			.map(id -> TimeZone.getTimeZone(id))
    			.sorted(Comparator.comparing(TimeZone::getID))
                .toList();
    }

    public List<TimeZone> getTimeZones() {
        return timeZones;
    }
}
