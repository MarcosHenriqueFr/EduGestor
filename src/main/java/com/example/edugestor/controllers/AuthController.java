package com.example.edugestor.controllers;

import com.example.edugestor.dto.CadastroRequest;
import com.example.edugestor.dto.CadastroResponse;
import com.example.edugestor.model.Funcionario;
import com.example.edugestor.model.enums.Cargo;
import com.example.edugestor.model.enums.Setor;
import com.example.edugestor.repositories.FuncionarioRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "auth")
@Validated
public class AuthController {

    private final FuncionarioRepository funcionarioRepository;

    public AuthController(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping(path = "cadastro")
    public String salvarFuncionario(@ModelAttribute @Valid CadastroRequest cadastroRequest, HttpSession session){

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(cadastroRequest.nome());
        funcionario.setEmail(cadastroRequest.email());
        funcionario.setSenha(cadastroRequest.senha());
        funcionario.setSetor(Setor.OPERACIONAL);
        funcionario.setCargo(Cargo.SUPORTE);

        funcionarioRepository.save(funcionario);

        CadastroResponse response = new CadastroResponse(
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getSetor(),
                funcionario.getCargo()
        );

        session.setAttribute("usuario", response);

        return "redirect:/home";
    }
}
