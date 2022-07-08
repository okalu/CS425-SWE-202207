package edu.miu.cs.cs425.fairfieldlibrarywebappsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/fairfieldlibrary"})
public class HomepageController {

    @GetMapping(value = {"/", "/public/home"})
    public String displayHomepage() {
        return "public/home/index";
    }

    @GetMapping(value = {"/public/about"})
    public String displayAboutpage() {
        return "public/home/about";
    }

}
