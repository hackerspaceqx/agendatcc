package br.ufc.qxd.agtcc.model.enums;


public enum UsuarioPapel {

	USER("user"),
	ADMIN("admin"),
	ALUNO("aluno"),
	ORIENTADOR("orientador"),
	COORDENACAO("coordenacao"),
	SECREATARIA("secretaria");

	private String descricao;

	private UsuarioPapel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
