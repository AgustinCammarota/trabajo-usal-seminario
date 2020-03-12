package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model, Principal principal, RedirectAttributes flash) {

        if (error != null) {
            model.addAttribute("danger", "Nombre de usuario o contraseña incorecta, por favor vuelva a intentarlo!");
        }

        if (logout != null) {
            model.addAttribute("success", "Ha cerrado sesion con exito!");
        }

        if (principal != null) {
            flash.addFlashAttribute("info", "Ya ha iniciado sesion anteriormente!");
            return "redirect:/listar";
        }
        return "login/login";
    }
}
