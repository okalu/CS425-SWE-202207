package com.gdm.srmwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/srm/home"})
    public String home() {
        return "public/index";
    }
}
