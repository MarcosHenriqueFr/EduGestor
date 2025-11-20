package com.example.edugestor.controllers;

import com.example.edugestor.dto.AlunoForm;
import com.example.edugestor.dto.AlunoListaResponse;
import com.example.edugestor.model.*;
import com.example.edugestor.repositories.AlunoRepository;
import com.example.edugestor.repositories.AlunosCursosRepository;
import com.example.edugestor.repositories.CursoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;
    private final AlunosCursosRepository alunosCursosRepository;

    public AlunoController(AlunoRepository alunoRepository,
                           CursoRepository cursoRepository,
                           AlunosCursosRepository alunosCursosRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
        this.alunosCursosRepository = alunosCursosRepository;
    }

    @GetMapping
    public String listarAlunos(Model model) {

        List<AlunoListaResponse> lista = alunosCursosRepository
                .findAll()
                .stream()
                .map(relacao -> new AlunoListaResponse(
                        relacao.getAluno().getMatricula(),
                        relacao.getAluno().getNome(),
                        relacao.getCurso().getNome(),
                        relacao.getCurso().getTurno().name()
                ))
                .toList();

        model.addAttribute("alunos", lista);
        return "alunos";
    }


    @GetMapping(path = "novo")
    public String novoAluno(Model model) {
        model.addAttribute("alunoForm", new AlunoForm("", null));
        model.addAttribute("cursos", cursoRepository.findAll());
        return "alunos-form";
    }


    @PostMapping
    public String salvarAluno(@ModelAttribute AlunoForm form) {

        Aluno aluno = new Aluno();
        aluno.setNome(form.nome());
        aluno = alunoRepository.save(aluno);

        Curso curso = cursoRepository.findById(form.idCurso()).orElseThrow();

        AlunoCursoId id = new AlunoCursoId();
        id.setMatriculaAluno(aluno.getMatricula());
        id.setIdCurso(curso.getId());

        AlunosCursos relacao = new AlunosCursos();
        relacao.setId(id);
        relacao.setAluno(aluno);
        relacao.setCurso(curso);

        alunosCursosRepository.save(relacao);

        return "redirect:/alunos";
    }

}
