package br.ufc.qxd.agtcc.model.entities;


import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 5873904911105568047L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;

	@Column
	private String descricao;

	@Column
	private Double mediaDeAprovacao;

	@ManyToMany
	@JoinTable(name = "curso_professor", joinColumns = { @JoinColumn(name = "curso_id") }, inverseJoinColumns = {
			@JoinColumn(name = "professor_id") })
	private List<Professor> professores;

//	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
//	private Boolean ativo;
	
	public Curso() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getMediaDeAprovacao() {
		return mediaDeAprovacao;
	}
	
	public void setMediaDeAprovacao(Double mediaDeAprovacao) {
		this.mediaDeAprovacao = mediaDeAprovacao;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((mediaDeAprovacao == null) ? 0 : mediaDeAprovacao.hashCode());
//		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
//		result = prime * result + ((professores == null) ? 0 : professores.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Curso other = (Curso) obj;
//		if (descricao == null) {
//			if (other.descricao != null)
//				return false;
//		} else if (!descricao.equals(other.descricao))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (mediaDeAprovacao == null) {
//			if (other.mediaDeAprovacao != null)
//				return false;
//		} else if (!mediaDeAprovacao.equals(other.mediaDeAprovacao))
//			return false;
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		if (professores == null) {
//			if (other.professores != null)
//				return false;
//		} else if (!professores.equals(other.professores))
//			return false;
//		return true;
//	}

}
