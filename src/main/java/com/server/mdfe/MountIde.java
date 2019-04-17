package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"cUF","tpAmb","tpEmit","tpTransp","mod","serie","nMDF","cMDF","cDV",
		"modal","dhEmi","tpEmis","procEmi","verProc","UFIni","UFFim","mountInfMunCarrega","dhIniViagem"})
public class MountIde {
	
	private int cUF;
	private int tpAmb;
	private int tpEmit;
	private int tpTransp;
	private int mod;
	private int serie;
	private int nMDF;
	private Long cMDF;
	private int cDV;
	private int modal;
	private String dhEmi;
	private int tpEmis;
	private int procEmi;
	private String verProc;
	private String UFIni;
	private String UFFim;
	private MountInfMunCarrega mountInfMunCarrega;
	private String dhIniViagem;

	public MountIde() {}
	
	public MountIde(int cUF, int tpAmb, int tpEmit, int tpTransp, int mod, int serie, int nMDF, Long cMDF, int cDV,
			int modal, String dhEmi, int tpEmis, int procEmi, String verProc, String uFIni, String uFFim,
			MountInfMunCarrega mountInfMunCarrega, String dhIniViagem) {
		this.cUF = cUF;
		this.tpAmb = tpAmb;
		this.tpEmit = tpEmit;
		this.tpTransp = tpTransp;
		this.mod = mod;
		this.serie = serie;
		this.nMDF = nMDF;
		this.cMDF = cMDF;
		this.cDV = cDV;
		this.modal = modal;
		this.dhEmi = dhEmi;
		this.tpEmis = tpEmis;
		this.procEmi = procEmi;
		this.verProc = verProc;
		UFIni = uFIni;
		UFFim = uFFim;
		this.mountInfMunCarrega = mountInfMunCarrega;
		this.dhIniViagem = dhIniViagem;
	}

	public int getcUF() {
		return cUF;
	}

	public void setcUF(int cUF) {
		this.cUF = cUF;
	}

	public int getTpAmb() {
		return tpAmb;
	}

	public void setTpAmb(int tpAmb) {
		this.tpAmb = tpAmb;
	}

	public int getTpEmit() {
		return tpEmit;
	}

	public void setTpEmit(int tpEmit) {
		this.tpEmit = tpEmit;
	}

	public int getTpTransp() {
		return tpTransp;
	}

	public void setTpTransp(int tpTransp) {
		this.tpTransp = tpTransp;
	}

	public int getMod() {
		return mod;
	}

	public void setMod(int mod) {
		this.mod = mod;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getnMDF() {
		return nMDF;
	}

	public void setnMDF(int nMDF) {
		this.nMDF = nMDF;
	}

	public Long getcMDF() {
		return cMDF;
	}

	public void setcMDF(Long cMDF) {
		this.cMDF = cMDF;
	}

	public int getcDV() {
		return cDV;
	}

	public void setcDV(int cDV) {
		this.cDV = cDV;
	}

	public int getModal() {
		return modal;
	}

	public void setModal(int modal) {
		this.modal = modal;
	}

	public String getDhEmi() {
		return dhEmi;
	}

	public void setDhEmi(String dhEmi) {
		this.dhEmi = dhEmi;
	}

	public int getTpEmis() {
		return tpEmis;
	}

	public void setTpEmis(int tpEmis) {
		this.tpEmis = tpEmis;
	}

	public int getProcEmi() {
		return procEmi;
	}

	public void setProcEmi(int procEmi) {
		this.procEmi = procEmi;
	}

	public String getVerProc() {
		return verProc;
	}

	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}

	public String getUFIni() {
		return UFIni;
	}

	public void setUFIni(String uFIni) {
		UFIni = uFIni;
	}

	public String getUFFim() {
		return UFFim;
	}

	public void setUFFim(String uFFim) {
		UFFim = uFFim;
	}

	@XmlElement(name="infMunCarrega")
	public MountInfMunCarrega getMountInfMunCarrega() {
		return mountInfMunCarrega;
	}

	public void setMountInfMunCarrega(MountInfMunCarrega mountInfMunCarrega) {
		this.mountInfMunCarrega = mountInfMunCarrega;
	}

	public String getDhIniViagem() {
		return dhIniViagem;
	}

	public void setDhIniViagem(String dhIniViagem) {
		this.dhIniViagem = dhIniViagem;
	}
	
}