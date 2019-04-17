package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountInfCiot {
	
	private String ciot;
	private String cnpj;

	public MountInfCiot() {}
	
	public MountInfCiot(String ciot, String cnpj) {
		this.ciot = ciot;
		this.cnpj = cnpj;
	}

	@XmlElement(name="CIOT")
	public String getCiot() {
		return ciot;
	}

	public void setCiot(String ciot) {
		this.ciot = ciot;
	}

	@XmlElement(name="CNPJ")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
