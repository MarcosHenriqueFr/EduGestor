package com.example.edugestor.controllers;

import com.example.edugestor.dto.CadastroRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping
    public String cadastrar(Model model){
        model.addAttribute("cadastroRequest", new CadastroRequest(null, null, null));
        return "cadastro";
    }
}
