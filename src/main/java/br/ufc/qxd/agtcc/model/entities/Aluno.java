package br.ufc.qxd.agtcc.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import br.ufc.qxd.agtcc.model.enums.*;

import java.io.Serializable;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 863969702519313932L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@NotNull
	private String primeiroNome;

	@Column
	@NotNull
	private String segundoNome;
	
	@Column
	private String nomeSocial;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataDeNascimento;
	
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> telefones;
	
	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Nacionalidade nacionalidade;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column
	@Enumerated(EnumType.STRING)
	private FormaTratamento tratamento;

	@Column(unique = true)
	@NotNull
	private String identidade;

	@Column
	@NotNull
	private String orgaoExpedidor;

	@Column(unique = true, nullable = false)
	private String cpf;
	
	@Column(nullable = false, unique = true)
	@NotNull
	private String matricula;

	@OneToOne
	private Curso curso;
	
	@OneToOne
	private Usuario usuario;

	public Aluno() {}
	
	

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

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((nomeSocial == null) ? 0 : nomeSocial.hashCode());
		result = prime * result + ((orgaoExpedidor == null) ? 0 : orgaoExpedidor.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
		result = prime * result + ((tratamento == null) ? 0 : tratamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
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
		Aluno other = (Aluno) obj;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null) {
				return false;
			}
		} else if (!dataDeNascimento.equals(other.dataDeNascimento)) {
			return false;
		}
		if (genero != other.genero) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (identidade == null) {
			if (other.identidade != null) {
				return false;
			}
		} else if (!identidade.equals(other.identidade)) {
			return false;
		}
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		if (nacionalidade != other.nacionalidade) {
			return false;
		}
		if (nomeSocial == null) {
			if (other.nomeSocial != null) {
				return false;
			}
		} else if (!nomeSocial.equals(other.nomeSocial)) {
			return false;
		}
		if (orgaoExpedidor == null) {
			if (other.orgaoExpedidor != null) {
				return false;
			}
		} else if (!orgaoExpedidor.equals(other.orgaoExpedidor)) {
			return false;
		}
		
		if (telefones == null) {
			if (other.telefones != null) {
				return false;
			}
		} else if (!telefones.equals(other.telefones)) {
			return false;
		}
		if (tratamento != other.tratamento) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}

}
