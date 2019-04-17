package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"cnpj","ie","xNome","xFant","mountEnderEmit"})
public class MountEmit {

	private String cnpj;
	private String ie;
	private String xNome;
	private String xFant;
	private MountEnderEmit mountEnderEmit;

	public MountEmit() {}
	
	public MountEmit(String cnpj, String ie, String xNome, String xFant, MountEnderEmit mountEnderEmit) {
		this.cnpj = cnpj;
		this.ie = ie;
		this.xNome = xNome;
		this.xFant = xFant;
		this.mountEnderEmit = mountEnderEmit;
	}

	@XmlElement(name="CNPJ")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@XmlElement(name="IE")
	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public String getxFant() {
		return xFant;
	}

	public void setxFant(String xFant) {
		this.xFant = xFant;
	}

	@XmlElement(name="enderEmit")
	public MountEnderEmit getMountEnderEmit() {
		return mountEnderEmit;
	}

	public void setMountEnderEmit(MountEnderEmit mountEnderEmit) {
		this.mountEnderEmit = mountEnderEmit;
	}

}
