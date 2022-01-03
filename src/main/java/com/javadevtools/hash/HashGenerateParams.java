package com.javadevtools.hash;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HashGenerateParams {
	@NotBlank(message = "Empty input")
	@Size(max = 5000, message = "Text length exceeds maximum allowed size: {max}")
	private final String text;
	
	public HashGenerateParams(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
