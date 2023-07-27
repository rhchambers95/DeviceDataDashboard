package com.ryanchambers.devicedata.controller;

import com.ryanchambers.devicedata.model.Console;
import com.ryanchambers.devicedata.service.TestLogParserService;
import com.ryanchambers.devicedata.service.TestLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    TestLogParserService tlps;
    TestLogService tls;

    public TestController(TestLogParserService tlps, TestLogService tls) {
        this.tlps = tlps;
        this.tls = tls;
    }

    @GetMapping("/1")
    public String get() {
        tlps.setFilename("src/main/resources/BIT3.01.00208_22.12.19.18.59.12.csv");

        Console console = tlps.createConsole();
        console.setId(12252);
        tls.saveConsole(console);

        return "Failure";


    }
}
