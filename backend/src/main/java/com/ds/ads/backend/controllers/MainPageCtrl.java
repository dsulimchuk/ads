package com.ds.ads.backend.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class MainPageCtrl {

    @RequestMapping("/")
    @ResponseBody
    String home() {
	return "Intentionally left blank";
    }

   
}