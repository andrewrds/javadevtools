package com.javadevtools;


import org.springframework.beans.factory.annotation.Autowired;
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
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String value = formatter.format(new Date());

		Map<String, Object> result = new HashMap<>();
		result.put("value", value);
		return result;
	}
}
