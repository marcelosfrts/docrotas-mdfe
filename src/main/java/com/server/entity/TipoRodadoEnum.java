package com.server.entity;

public enum TipoRodadoEnum {
	
	TRUCK("01"),
	TOCO("02"),
	VAN("04"),
	UTILITARIO("05"),
	OUTROS("06");
	
	private String descricao;
	
	TipoRodadoEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}