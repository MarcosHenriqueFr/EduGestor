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

/**
 * Essa classe contém toda a lógica sobre a entidade {@link Aluno}
 * <p>
 *     Ela contém métodos que relacionam {@link Aluno} e {@link Curso}
 * </p>
 */
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

    /**
     * <p>
     *     Esse método mostra a página principal de criação de novos alunos,
     *     fazendo a busca de toda a informação através da Entidade Associativa {@link AlunosCursos}
     * </p>
     * @param model Para mandar a lista temporária para a página de alunos
     * @return Renderiza a página de alunos
     */
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

    /**
     *
     * @param model Para enviar o DTO e os cursos disponíveis para a página no endpoint("/alunos/novo")
     * @return A página renderizada com o formulário de alunos
     */
    @GetMapping(path = "novo")
    public String novoAluno(Model model) {
        model.addAttribute("alunoForm", new AlunoForm("", null));
        model.addAttribute("cursos", cursoRepository.findAll());
        return "alunos-form";
    }


    /**
     * <p>
     *     Esse método é executado logo após o submit do form para salvar o aluno no banco
     * </p>
     * @param form O dto para mapeamento de cursos e nome do aluno
     * @return Redireciona o usuário novamente para a página de listagem de alunos
     */
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
