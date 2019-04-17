package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountCondutor {
	
	private String xNome;
	private String cpf;

	public MountCondutor() {}
	
	public MountCondutor(String xNome, String cpf) {
		this.xNome = xNome;
		this.cpf = cpf;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	@XmlElement(name="CPF")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
