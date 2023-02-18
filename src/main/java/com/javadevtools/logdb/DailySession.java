package com.javadevtools.logdb;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "uq_daily_session", columnNames = {"sessionDate", "requestType"}))
public class DailySession {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private LocalDate sessionDate;
    
    @NotNull
    private RequestType requestType;
    
    private long sessionCount;
    
    public static DailySession create(LocalDate sessionDate, RequestType requestType, long sessionCount) {
        DailySession result = new DailySession();
        result.sessionDate = sessionDate;
        result.requestType = requestType;
        result.sessionCount = sessionCount;
        return result;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public long getSessionCount() {
        return sessionCount;
    }
    
}