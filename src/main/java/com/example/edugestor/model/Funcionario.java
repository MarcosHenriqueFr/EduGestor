package com.example.edugestor.model;

import java.io.Serializable;
import java.util.Objects;

import com.example.edugestor.model.enums.Cargo;
import com.example.edugestor.model.enums.Setor;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = -4545931805273866446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

    @Column(length = 150)
    String nome;

    @Column(nullable = false, length = 150, unique = true)
    String email;

    @Column(nullable = false, length = 120)
    String senha;
	
	@Enumerated(EnumType.STRING)
	private Setor setor;
	
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	public Funcionario() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
