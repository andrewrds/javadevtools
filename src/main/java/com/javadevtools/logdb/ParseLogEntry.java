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
public class ParseLogEntry {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    private Instant created;
    
    @NotBlank
    private String sessionId;
    
    @NotBlank
    @Size(max = 300)
    private String formatPattern;
    
    @NotBlank
    @Size(max = 300)
    private String parseText;
    
    @NotNull
    private FormatterType formatterType;

    public static ParseLogEntry create(
    		String sessionId,
    		String formatPattern,
    		String parseText,
    		FormatterType formatterType) {
    	
		ParseLogEntry logEntry = new ParseLogEntry();
		logEntry.created = Instant.now();
		logEntry.sessionId = sessionId;
		logEntry.formatPattern = formatPattern;
		logEntry.parseText = parseText;
		logEntry.formatterType = formatterType;
		return logEntry;
    }
}