package com.javadevtools.logdb;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.javadevtools.dateformat.FormatterType;

@Entity
public class FormatLogEntry {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    private Instant created;
    
    @NotBlank
    private String sessionId;
    
    @NotBlank
    @Size(max = 100)
    private String formatPattern;
    
    @NotNull
    private FormatterType formatterType;

    public static FormatLogEntry create(String sessionId, String formatPattern, FormatterType formatterType) {
		FormatLogEntry logEntry = new FormatLogEntry();
		logEntry.created = Instant.now();
		logEntry.sessionId = sessionId;
		logEntry.formatPattern = formatPattern;
		logEntry.formatterType = formatterType;
		return logEntry;
    }
}