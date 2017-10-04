package br.ufc.qxd.agtcc.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.ufc.qxd.agtcc.model.enums.UsuarioPapel;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	// Atributos
	private static final long serialVersionUID = 6038424314326266692L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	@NotNull
	private String login;

	@Column(unique = true, nullable = false)
	@NotNull
	private String email;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private UsuarioPapel papel;

	@Column(nullable = false)
	@NotNull
	private String password;

	// Construtor
	public Usuario() {
	}

	// Metodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioPapel getPapel() {
		return papel;
	}

	public void setPapel(UsuarioPapel papel) {
		this.papel = papel;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
	// result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
	// result = prime * result + ((dataDeCadastro == null) ? 0 :
	// dataDeCadastro.hashCode());
	// result = prime * result + ((email == null) ? 0 : email.hashCode());
	// result = prime * result + ((id == null) ? 0 : id.hashCode());
	// result = prime * result + ((login == null) ? 0 : login.hashCode());
	// result = prime * result + ((password == null) ? 0 : password.hashCode());
	//// result = prime * result + ((passwordHash == null) ? 0 :
	// passwordHash.hashCode());
	// result = prime * result + ((primeiroNome == null) ? 0 :
	// primeiroNome.hashCode());
	// result = prime * result + ((segundoNome == null) ? 0 :
	// segundoNome.hashCode());
	// result = prime * result + ((papel == null) ? 0 : papel.hashCode());
	// return result;
	// }
	
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Usuario other = (Usuario) obj;
	// if (ativo == null) {
	// if (other.ativo != null)
	// return false;
	// } else if (!ativo.equals(other.ativo))
	// return false;
	// if (cpf == null) {
	// if (other.cpf != null)
	// return false;
	// } else if (!cpf.equals(other.cpf))
	// return false;
	// if (dataDeCadastro == null) {
	// if (other.dataDeCadastro != null)
	// return false;
	// } else if (!dataDeCadastro.equals(other.dataDeCadastro))
	// return false;
	// if (email == null) {
	// if (other.email != null)
	// return false;
	// } else if (!email.equals(other.email))
	// return false;
	// if (id == null) {
	// if (other.id != null)
	// return false;
	// } else if (!id.equals(other.id))
	// return false;
	// if (login == null) {
	// if (other.login != null)
	// return false;
	// } else if (!login.equals(other.login))
	// return false;
	// if (password == null) {
	// if (other.password != null)
	// return false;
	// } else if (!password.equals(other.password))
	// return false;
	//// if (passwordHash == null) {
	//// if (other.passwordHash != null)
	//// return false;
	//// } else if (!passwordHash.equals(other.passwordHash))
	//// return false;
	// if (primeiroNome == null) {
	// if (other.primeiroNome != null)
	// return false;
	// } else if (!primeiroNome.equals(other.primeiroNome))
	// return false;
	// if (segundoNome == null) {
	// if (other.segundoNome != null)
	// return false;
	// } else if (!segundoNome.equals(other.segundoNome))
	// return false;
	// if (papel == null) {
	// if (other.papel != null)
	// return false;
	// } else if (!papel.equals(other.papel))
	// return false;
	// return true;
	// }

}
