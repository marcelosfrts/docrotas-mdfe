package com.server.entity;

public enum TipoCarroceriaEnum {

	NAO_APLICAVEL("00"),
	ABERTA("01"),
	FECHADA_BAU("02"),
	GRANELEIRA("03"),
	PORTA_CONTAINER("04"),
	SIDER("05");
	
	private String descricao;
	
	TipoCarroceriaEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
