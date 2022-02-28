package com.javadevtools.hash;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record HashGenerateParams(
	@NotBlank(message = "Empty input")
	@Size(max = 5000, message = "Text length exceeds maximum allowed size: {max}")
	String text) {}