package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountInfMunDescarga {
	
	private String cMunDescarga;
	private String xMunDescarga;
	private MountInfCTe mountInfCTe;

	public MountInfMunDescarga() {}
	
	public MountInfMunDescarga(String cMunDescarga, String xMunDescarga, MountInfCTe mountInfCTe) {
		this.cMunDescarga = cMunDescarga;
		this.xMunDescarga = xMunDescarga;
		this.mountInfCTe = mountInfCTe;
	}

	public String getcMunDescarga() {
		return cMunDescarga;
	}

	public void setcMunDescarga(String cMunDescarga) {
		this.cMunDescarga = cMunDescarga;
	}

	public String getxMunDescarga() {
		return xMunDescarga;
	}

	public void setxMunDescarga(String xMunDescarga) {
		this.xMunDescarga = xMunDescarga;
	}
	
	@XmlElement(name="infCTe")
	public MountInfCTe getMountInfCTe() {
		return mountInfCTe;
	}

	public void setMountInfCTe(MountInfCTe mountInfCTe) {
		this.mountInfCTe = mountInfCTe;
	}

}
