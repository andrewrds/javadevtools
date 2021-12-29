package com.javadevtools;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class LocaleService {
    private List<Locale> locales;

    @PostConstruct
    private void init() {
        locales = Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> !l.getDisplayName().isBlank())
                .sorted(Comparator.comparing(Locale::getDisplayName))
                .collect(Collectors.toList());
    }

    public List<Locale> getLocales() {
        return locales;
    }
}
