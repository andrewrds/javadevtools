package com.javadevtools.dateparse;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParseRestController {
    private final ParseService parseService;
    private final SimpleDateFormatParseWrapper simpleDateFormatWrapper;
    private final DateTimeFormatterParseWrapper dateTimeFormatterWrapper;

    public ParseRestController(
            ParseService formatterService,
            SimpleDateFormatParseWrapper simpleDateFormatWrapper,
            DateTimeFormatterParseWrapper dateTimeFormatterWrapper) {
        this.parseService = formatterService;
        this.simpleDateFormatWrapper = simpleDateFormatWrapper;
        this.dateTimeFormatterWrapper = dateTimeFormatterWrapper;
    }
    
    @GetMapping("/simpledateformat/parse")
    public Map<String, Object> simpleDateFormat(@Valid ParseParamsWithTimeZone params, HttpSession session) {
        return parseService.format(session.getId(), params, simpleDateFormatWrapper);
    }

    @GetMapping("/datetimeformatter/parse")
    public Map<String, Object> dateTimeFormat(@Valid ParseParams params, HttpSession session) {
        return parseService.format(session.getId(), params, dateTimeFormatterWrapper);
    }
}
