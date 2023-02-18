package com.javadevtools.dateparse;

import java.time.ZoneId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParseParams {
    @NotBlank(message = "Empty pattern")
    @Size(max = 300, message = "Pattern length exceeds maximum allowed size: {max}")
    private final String pattern;
    
    @NotBlank(message = "Empty input text")
    @Size(max = 300, message = "Pattern length exceeds maximum allowed size: {max}")
    private final String text;
    
    @NotBlank(message = "Locale cannot be blank")
    @Size(max = 100, message = "Locale length exceeds maximum allowed size: {max}")
    private final String locale;
    
    public ParseParams(
            String pattern,
            String text,
            String locale) {
        this.pattern = pattern;
        this.text = text;
        this.locale = locale;
    }

    public String getPattern() {
        return pattern;
    }
    
    public String getText() {
        return text;
    }

    public String getLocale() {
        return locale;
    }
    
    public ZoneId getTimeZone() {
        return ZoneId.systemDefault();
    }
}
