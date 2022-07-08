package edu.miu.cs.cs425.fairfieldlibrarywebappsec.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping(value = {"/public/login", "/fairfieldlibrary/public/login"})
    public String displayLoginPage() {
        return "public/login/login";
    }

    @PostMapping(value = {"/public/logout", "/fairfieldlibrary/public/logout"})
    public String doLogout(HttpServletRequest request, HttpServletResponse response,
                           Authentication authentication) throws ServletException {
        request.logout();
        return "redirect:/fairfieldlibrary/public/login?logout";
    }
}
