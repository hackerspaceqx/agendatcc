package br.ufc.qxd.agtcc.model.entities;


import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private Boolean ativo;

	@Column
	private Double mediaDeAprovacao;

	@Column
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeInicio;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeTermino;

	@ManyToMany
	@JoinTable(name = "curso_professor", joinColumns = { @JoinColumn(name = "curso_id") }, inverseJoinColumns = {
			@JoinColumn(name = "professor_id") })
	private List<Professor> professores;

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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getMediaDeAprovacao() {
		return mediaDeAprovacao;
	}

	public void setMediaDeAprovacao(Double mediaDeAprovacao) {
		this.mediaDeAprovacao = mediaDeAprovacao;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((dataDeInicio == null) ? 0 : dataDeInicio.hashCode());
		result = prime * result + ((dataDeTermino == null) ? 0 : dataDeTermino.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mediaDeAprovacao == null) ? 0 : mediaDeAprovacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((professores == null) ? 0 : professores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (dataDeInicio == null) {
			if (other.dataDeInicio != null)
				return false;
		} else if (!dataDeInicio.equals(other.dataDeInicio))
			return false;
		if (dataDeTermino == null) {
			if (other.dataDeTermino != null)
				return false;
		} else if (!dataDeTermino.equals(other.dataDeTermino))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mediaDeAprovacao == null) {
			if (other.mediaDeAprovacao != null)
				return false;
		} else if (!mediaDeAprovacao.equals(other.mediaDeAprovacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (professores == null) {
			if (other.professores != null)
				return false;
		} else if (!professores.equals(other.professores))
			return false;
		return true;
	}

}
