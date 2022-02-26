package com.javadevtools.dateformat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

record DateFormatParams(
	@NotBlank(message = "Empty input")
	@Size(max = 300, message = "Pattern length exceeds maximum allowed size: {max}")
	String pattern,
	
	@NotBlank(message = "Locale cannot be blank")
	@Size(max = 100, message = "Locale length exceeds maximum allowed size: {max}")
	String locale,
	
	@NotBlank(message = "Time zone cannot be blank")
	@Size(max = 100, message = "Time zone length exceeds maximum allowed size: {max}")
	String timeZone) {}