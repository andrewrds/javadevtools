package com.javadevtools.dateformat;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatterRestController {
	private final FormtterService formatterService;
	private final SimpleDateFormatWrapper simpleDateFormatWrapper;
	private final DateTimeFormatterWrapper dateTimeFormatterWrapper;

	public FormatterRestController(
			FormtterService formatterService,
			SimpleDateFormatWrapper simpleDateFormatWrapper,
			DateTimeFormatterWrapper dateTimeFormatterWrapper) {
		this.formatterService = formatterService;
		this.simpleDateFormatWrapper = simpleDateFormatWrapper;
		this.dateTimeFormatterWrapper = dateTimeFormatterWrapper;
	}
	
	@GetMapping("/simpledateformat/format")
	public Map<String, Object> simpleDateFormat(@Valid DateFormatParams params, HttpSession session) {
		return formatterService.format(
				session.getId(),
				params,
				simpleDateFormatWrapper);
	}

	@GetMapping("/datetimeformatter/format")
	public Map<String, Object> dateTimeFormat(@Valid DateFormatParams params, HttpSession session) {
		return formatterService.format(
				session.getId(),
				params,
				dateTimeFormatterWrapper);
	}
}
