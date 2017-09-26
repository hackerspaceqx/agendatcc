package br.ufc.qxd.agtcc.model.enums;


public enum FormaTratamento {
	SENHOR("Sr."), 
	SENHORA("Sra."), 
	SENHORITA("Srta."), 
	DOUTOR("Dr."), 
	DOUTORA("Dra."), 
	PROFESSOR("Prof."), 
	PROFESSORA("Profa.");
	
	private String descricao;

	private FormaTratamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
