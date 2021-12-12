package com.javadevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaVersionController {
	private static final String javaVersion = System.getProperty("java.version");

	@GetMapping("/javaVersion")
	public String getJavaVersion() {
		return javaVersion;
	}
}
