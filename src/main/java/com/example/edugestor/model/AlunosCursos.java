package com.example.edugestor.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos_cursos")
public class AlunosCursos implements Serializable {

	private static final long serialVersionUID = -6137280095940621056L;

	@EmbeddedId
	private AlunoCursoId id;
	
	@ManyToOne
	@MapsId("matriculaAluno")
	private Aluno aluno;
	
	@ManyToOne
	@MapsId("idCurso")
	private Curso curso;
	
	public AlunosCursos() {
		
	}

	public AlunoCursoId getId() {
		return id;
	}

	public void setId(AlunoCursoId id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
