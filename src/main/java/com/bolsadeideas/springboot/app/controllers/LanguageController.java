package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LanguageController {

    @GetMapping("/locale")
    public String locale(HttpServletRequest request) {
        //El referer nos entrega la referencia de la ultima url
        String ultimaUrl = request.getHeader("referer");

        return "redirect:".concat(ultimaUrl);
    }
}
