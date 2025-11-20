package com.example.edugestor.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlunoCursoId implements Serializable {

	private static final long serialVersionUID = -6167992348851459831L;

	@Column(name = "matricula_aluno")
	private Long matriculaAluno;
	
	@Column(name = "id_curso")
	private Long idCurso;
	
	public AlunoCursoId() {
		
	}

	public Long getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(Long matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCurso, matriculaAluno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoCursoId other = (AlunoCursoId) obj;
		return Objects.equals(idCurso, other.idCurso) && Objects.equals(matriculaAluno, other.matriculaAluno);
	}
}
