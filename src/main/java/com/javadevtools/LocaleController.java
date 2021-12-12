package com.javadevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@RestController
public class LocaleController {
    private Map<String, String> locales;

    @PostConstruct
    private void init() {
        locales = Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> !l.getDisplayName().isBlank())
                .sorted((l1, l2) -> l1.getDisplayName().compareTo(l2.getDisplayName()))
                .collect(Collectors.toMap(
                        l -> l.toLanguageTag(),
                        l -> l.getDisplayName(),
                        (l1, l2) -> l1,
                        LinkedHashMap::new));
    }

    @GetMapping("/locales")
    public Map<String, String> getLocales() {
        return locales;
    }
}
