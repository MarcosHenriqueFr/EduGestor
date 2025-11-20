package com.example.edugestor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "usuario")
public class UsuarioController {

    @GetMapping(path = "perfil")
    public String perfil(){
        return "perfil";
    }
}
