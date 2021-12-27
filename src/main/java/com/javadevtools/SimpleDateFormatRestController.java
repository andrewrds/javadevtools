package com.javadevtools;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleDateFormatRestController {

	@RequestMapping("/simpledateformat/format")
	public Map<String, Object> format(@RequestParam String pattern) {
		Map<String, Object> result = new HashMap<>();

		if (pattern.isBlank()) {
			result.put("value", "Empty input");
		} else {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(pattern);
				String value = formatter.format(new Date());

				result.put("value", value);
			} catch (IllegalArgumentException e) {
				result.put("value", e.getMessage());
				result.put("error", true);
			}
		}

		return result;
	}
}
