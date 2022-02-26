package com.javadevtools.system;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class LocaleService {
    private final List<Locale> locales;
    
    public LocaleService() {
        locales = Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> !l.getDisplayName().isBlank())
                .sorted(Comparator.comparing(l -> l.toLanguageTag() + ": " + l.getDisplayName()))
                .toList();
    }

    public List<Locale> getLocales() {
        return locales;
    }
}
