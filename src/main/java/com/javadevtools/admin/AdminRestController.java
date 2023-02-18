package com.javadevtools.admin;


import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadevtools.logdb.DailyStatsService;

@RestController
public class AdminRestController {
    private final DailyStatsService dailyStats;
    
    public AdminRestController(DailyStatsService dailyStats) {
        this.dailyStats = dailyStats;
    }

    @GetMapping("/admin/dailystats")
    public Map<String, Object> admin(Map<String, Object> model) {
        return dailyStats.getData();
    }
    
}
