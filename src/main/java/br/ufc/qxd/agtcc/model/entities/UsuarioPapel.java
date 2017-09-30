package br.ufc.qxd.agtcc.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UsuarioPapel implements Serializable{
	
	private static final long serialVersionUID = 5577951248345039295L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nome = "USER";

	public UsuarioPapel() {}
	
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
	
	
}
