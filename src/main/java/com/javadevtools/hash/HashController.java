package com.javadevtools.hash;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HashController {
	
	@GetMapping("/hash")
	public String hash() {
		return "hash";
	}
}
