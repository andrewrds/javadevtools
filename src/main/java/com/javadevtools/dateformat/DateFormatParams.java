package com.javadevtools.dateformat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DateFormatParams {
	@NotBlank(message = "Empty input")
	@Size(max = 300, message = "Pattern length exceeds maximum allowed size: {max}")
	private String pattern;
	
	@NotBlank(message = "Locale cannot be blank")
	@Size(max = 100, message = "Locale length exceeds maximum allowed size: {max}")
	private String locale;
	
	@NotBlank(message = "Time zone cannot be blank")
	@Size(max = 100, message = "Time zone length exceeds maximum allowed size: {max}")
	private String timeZone;
	
	public String getPattern() {
		return pattern;
	}

	public String getLocale() {
		return locale;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	
}
