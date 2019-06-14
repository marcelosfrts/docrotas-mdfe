package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"xLgr","nro","xBairro","cMun","xMun","cep","uf","fone"})
public class MountEnderEmit {

	private String xLgr;
	private Long nro;
	private String xBairro;
	private Long cMun;
	private String xMun;
	private String cep;
	private String uf;
	private String fone;

	public MountEnderEmit() {}
	
	public MountEnderEmit(String xLgr, Long nro, String xBairro, Long cMun, String xMun, String cep, String uf,	String fone) {
		this.xLgr = xLgr;
		this.nro = nro;
		this.xBairro = xBairro;
		this.cMun = cMun;
		this.xMun = xMun;
		this.cep = cep;
		this.uf = uf;
		this.fone = fone;
	}

	public String getxLgr() {
		return xLgr;
	}

	public void setxLgr(String xLgr) {
		this.xLgr = xLgr;
	}

	public Long getNro() {
		return nro;
	}

	public void setNro(Long nro) {
		this.nro = nro;
	}

	public String getxBairro() {
		return xBairro;
	}

	public void setxBairro(String xBairro) {
		this.xBairro = xBairro;
	}

	public Long getcMun() {
		return cMun;
	}

	public void setcMun(Long cMun) {
		this.cMun = cMun;
	}

	public String getxMun() {
		return xMun;
	}

	public void setxMun(String xMun) {
		this.xMun = xMun;
	}

	@XmlElement(name="CEP")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@XmlElement(name="UF")
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
}
