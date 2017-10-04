package br.ufc.qxd.agtcc.model.entities;


import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.ufc.qxd.agtcc.model.enums.FormaTratamento;
import br.ufc.qxd.agtcc.model.enums.Genero;
import br.ufc.qxd.agtcc.model.enums.Nacionalidade;
import br.ufc.qxd.agtcc.model.enums.TitulacaoAcademica;

import java.io.Serializable;

@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = -8740211792761807927L;

@Id
@GeneratedValue
private Long id;

	@Column(nullable = false)
	@NotNull
	private String primeiroNome;
	
	@Column
	@NotNull
	private String segundoNome;

	@Column(unique = true, nullable = false)
	@NotNull
	private String identidade;
	
	@Column(nullable = false)
	@NotNull
	private String orgaoExpedidor;

	@Column(unique = true, nullable = false)
	@NotNull
	private String cpf;

	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> telefones;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Nacionalidade nacionalidade;


	@Column(name = "titulacao", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private TitulacaoAcademica titulacaoAcademica;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Column(name = "tratamento", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private FormaTratamento tratamento;

	@ManyToMany(mappedBy = "professores")
	private List<Curso> cursos;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Usuario usuario;
	

	public Professor() {}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public TitulacaoAcademica getTitulacaoAcademica() {
		return titulacaoAcademica;
	}

	public void setTitulacaoAcademica(TitulacaoAcademica titulacaoAcademica) {
		this.titulacaoAcademica = titulacaoAcademica;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public FormaTratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(FormaTratamento tratamento) {
		this.tratamento = tratamento;
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

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 71 * hash + Objects.hashCode(this.id);
		hash = 71 * hash + Objects.hashCode(this.identidade);
		hash = 71 * hash + Objects.hashCode(this.orgaoExpedidor);
		hash = 71 * hash + Objects.hashCode(this.titulacaoAcademica);
		hash = 71 * hash + Objects.hashCode(this.tratamento);
		hash = 71 * hash + Objects.hashCode(this.cursos);
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
		if (this.tratamento != other.tratamento) {
			return false;
		}
		if (!Objects.equals(this.cursos, other.cursos)) {
			return false;
		}
		return Objects.equals(this.usuario, other.usuario);
	}

}
