package com.javadevtools.system;

import org.springframework.stereotype.Component;

@Component
public class JavaVersionService {
	private static final String javaVersion = System.getProperty("java.version");

	public String getJavaVersion() {
		return javaVersion;
	}
}
