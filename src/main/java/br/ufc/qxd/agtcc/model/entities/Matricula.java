package br.ufc.qxd.agtcc.model.entities;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Matricula implements Serializable {

	private static final long serialVersionUID = -209772297296140981L;

	@Id
	@GeneratedValue
	private Long id;

	private String matricula;

	@ManyToOne(optional = false)
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private Aluno aluno;

	@ManyToOne(optional = false)
	@JoinColumn(name = "curso_id", referencedColumnName = "id")
	private Curso curso;

	public Matricula() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 23 * hash + Objects.hashCode(this.id);
		hash = 23 * hash + Objects.hashCode(this.matricula);
		hash = 23 * hash + Objects.hashCode(this.aluno);
		hash = 23 * hash + Objects.hashCode(this.curso);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Matricula other = (Matricula) obj;
		if (!Objects.equals(this.matricula, other.matricula)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.aluno, other.aluno)) {
			return false;
		}
		if (!Objects.equals(this.curso, other.curso)) {
			return false;
		}
		return true;
	}

}
