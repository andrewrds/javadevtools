package com.javadevtools;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TimeZoneService {
    private List<TimeZone> timeZones;

    @PostConstruct
    private void init() {
    	timeZones = Arrays.stream(TimeZone.getAvailableIDs())
    			.map(id -> TimeZone.getTimeZone(id))
    			.sorted(Comparator.comparing(TimeZone::getID))
                .collect(Collectors.toList());
    }

    public List<TimeZone> getTimeZones() {
        return timeZones;
    }
}
