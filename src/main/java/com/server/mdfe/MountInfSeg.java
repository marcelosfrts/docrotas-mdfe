package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountInfSeg {

	private String xSeg;
	private String cnpj;
	
	public MountInfSeg() {}
	
	public MountInfSeg(String xSeg, String cnpj) {
		this.xSeg = xSeg;
		this.cnpj = cnpj;
	}

	public String getxSeg() {
		return xSeg;
	}

	public void setxSeg(String xSeg) {
		this.xSeg = xSeg;
	}
	
	@XmlElement(name="CNPJ")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
