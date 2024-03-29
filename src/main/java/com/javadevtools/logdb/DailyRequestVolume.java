package com.javadevtools.logdb;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "uq_daily_request_vol", columnNames = {"requestDate", "requestType"}))
public class DailyRequestVolume {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private LocalDate requestDate;
    
    @NotNull
    private RequestType requestType;
    
    private long requestCount;
    
    public static DailyRequestVolume create(LocalDate requestDate, RequestType requestType, long requestCount) {
        DailyRequestVolume result = new DailyRequestVolume();
        result.requestDate = requestDate;
        result.requestType = requestType;
        result.requestCount = requestCount;
        return result;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public long getRequestCount() {
        return requestCount;
    }
    
}