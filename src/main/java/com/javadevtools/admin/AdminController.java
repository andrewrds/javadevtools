package com.javadevtools.admin;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin(Map<String, Object> model) {
        return "admin";
    }
    
}
