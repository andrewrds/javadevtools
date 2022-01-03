package com.javadevtools.hash;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashRestController {
	private final HashGeneratorService generatorService;

	public HashRestController(HashGeneratorService generatorService) {
		this.generatorService = generatorService;
	}
	
	@GetMapping("/hash/generate")
	public Map<String, Object> simpleDateFormat(@Valid HashGenerateParams params) {
		return generatorService.generate(params);
	}
}
