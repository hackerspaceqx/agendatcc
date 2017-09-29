package br.ufc.qxd.agtcc.model.entities;


import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.ufc.qxd.agtcc.model.enums.FormaTratamento;
import br.ufc.qxd.agtcc.model.enums.TitulacaoAcademica;

import java.io.Serializable;

@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = -8740211792761807927L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	@NotNull
	private String identidade;

	@Column(nullable = false)
	@NotNull
	private String orgaoExpedidor;

	@Column(name = "titulacao", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private TitulacaoAcademica titulacaoAcademica;

	@Column(name = "tratamento", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private FormaTratamento formaTratamento;

	@ManyToMany(mappedBy = "professores")
	private List<Curso> cursos;

	@Column(nullable = false)
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Usuario usuario;
	
	@Column(nullable = false)
	@NotNull
	private Matricula matricula;

	public Professor() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public TitulacaoAcademica getTitulacaoAcademica() {
		return titulacaoAcademica;
	}

	public void setTitulacaoAcademica(TitulacaoAcademica titulacaoAcademica) {
		this.titulacaoAcademica = titulacaoAcademica;
	}

	public FormaTratamento getTratamento() {
		return formaTratamento;
	}

	public void setTratamento(FormaTratamento tratamento) {
		this.formaTratamento = tratamento;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 71 * hash + Objects.hashCode(this.id);
		hash = 71 * hash + Objects.hashCode(this.identidade);
		hash = 71 * hash + Objects.hashCode(this.orgaoExpedidor);
		hash = 71 * hash + Objects.hashCode(this.titulacaoAcademica);
		hash = 71 * hash + Objects.hashCode(this.formaTratamento);
		hash = 71 * hash + Objects.hashCode(this.cursos);
		hash = 71 * hash + Objects.hashCode(this.matricula);
		hash = 71 * hash + Objects.hashCode(this.usuario);
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
		final Professor other = (Professor) obj;
		if (!Objects.equals(this.identidade, other.identidade)) {
			return false;
		}
		if (!Objects.equals(this.orgaoExpedidor, other.orgaoExpedidor)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (this.titulacaoAcademica != other.titulacaoAcademica) {
			return false;
		}
		if (this.formaTratamento != other.formaTratamento) {
			return false;
		}
		if (!Objects.equals(this.cursos, other.cursos)) {
			return false;
		}
		if (!Objects.equals(this.matricula, other.matricula)) {
			return false;
		}
		return Objects.equals(this.usuario, other.usuario);
	}

}
