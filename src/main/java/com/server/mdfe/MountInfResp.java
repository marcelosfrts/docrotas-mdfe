package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"respSeg","cnpj"})
public class MountInfResp {

	private Integer respSeg;
	private String cnpj;
	
	public MountInfResp() {}
	
	public MountInfResp(Integer respSeg, String cnpj) {
		this.respSeg = respSeg;
		this.cnpj = cnpj;
	}

	public Integer getRespSeg() {
		return respSeg;
	}

	public void setRespSeg(Integer respSeg) {
		this.respSeg = respSeg;
	}
	
	@XmlElement(name="CNPJ")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
