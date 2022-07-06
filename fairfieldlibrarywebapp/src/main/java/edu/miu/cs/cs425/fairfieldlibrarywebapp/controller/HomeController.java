package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/home", "/fairfieldlibrary/home"})
    public String displayHomepage() {
        return "public/index";
    }

    @GetMapping(value = {"/fairfieldlibrary/about"})
    public String displayAboutpage() {
        return "public/about";
    }
}
