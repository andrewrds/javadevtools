package com.javadevtools.dateparse;

import java.time.ZoneId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParseParamsWithTimeZone extends ParseParams {

	@NotBlank(message = "Time zone cannot be blank")
	@Size(max = 100, message = "Time zone length exceeds maximum allowed size: {max}")
	private final String timeZone;
	
	public ParseParamsWithTimeZone(
			String pattern,
			String text,
			String locale,
			String timeZone) {
		super(pattern, text, locale);
		this.timeZone = timeZone;
	}

	@Override
	public ZoneId getTimeZone() {
		return ZoneId.of(timeZone);
	}
}
