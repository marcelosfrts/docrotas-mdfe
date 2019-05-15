package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"placa","renavam","tara","capkg","mountCondutor","tpRod","tpCar","uf"})
public class MountVeicTracao {

	private String placa;
	private String renavam;
	private Long tara;
	private Long capkg;
	private MountCondutor mountCondutor;
	private String tpRod;
	private String tpCar;
	private String uf;

	public MountVeicTracao() {}
	
	public MountVeicTracao(String placa, String renavam, Long tara, Long capkg, MountCondutor mountCondutor, String tpRod,
			String tpCar, String uf) {
		this.placa = placa;
		this.renavam = renavam;
		this.tara = tara;
		this.capkg = capkg;
		this.mountCondutor = mountCondutor;
		this.tpRod = tpRod;
		this.tpCar = tpCar;
		this.uf = uf;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@XmlElement(name="RENAVAM")
	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public Long getTara() {
		return tara;
	}

	public void setTara(Long tara) {
		this.tara = tara;
	}

	@XmlElement(name="capKG")
	public Long getCapkg() {
		return capkg;
	}

	public void setCapkg(Long capkg) {
		this.capkg = capkg;
	}

	@XmlElement(name="condutor")
	public MountCondutor getMountCondutor() {
		return mountCondutor;
	}

	public void setMountCondutor(MountCondutor mountCondutor) {
		this.mountCondutor = mountCondutor;
	}

	public String getTpRod() {
		return tpRod;
	}

	public void setTpRod(String tpRod) {
		this.tpRod = tpRod;
	}

	public String getTpCar() {
		return tpCar;
	}

	public void setTpCar(String tpCar) {
		this.tpCar = tpCar;
	}

	@XmlElement(name="UF")
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
