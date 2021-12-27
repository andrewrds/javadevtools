package com.javadevtools;

import org.springframework.stereotype.Service;

@Service
public class JavaVersionService {
	private static final String javaVersion = System.getProperty("java.version");

	public String getJavaVersion() {
		return javaVersion;
	}
}
