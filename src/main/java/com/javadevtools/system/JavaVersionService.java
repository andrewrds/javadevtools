package com.javadevtools.system;

import org.springframework.stereotype.Component;

@Component
public class JavaVersionService {
    private final String javaVersion = System.getProperty("java.version");

    public String getJavaVersion() {
        return javaVersion;
    }
}
