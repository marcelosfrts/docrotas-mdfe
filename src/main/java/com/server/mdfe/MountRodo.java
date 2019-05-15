package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountRodo {

	private MountInfAntt mountInfAntt;
	private MountVeicTracao mountVeicTracao;

	public MountRodo() {}	
	
	public MountRodo(MountInfAntt mountInfAntt, MountVeicTracao mountVeicTracao) {
		this.mountInfAntt = mountInfAntt;
		this.mountVeicTracao = mountVeicTracao;
	}

	@XmlElement(name="infANTT")
	public MountInfAntt getMountInfAntt() {
		return mountInfAntt;
	}

	public void setMountInfAntt(MountInfAntt mountInfAntt) {
		this.mountInfAntt = mountInfAntt;
	}

	@XmlElement(name="veicTracao")
	public MountVeicTracao getMountVeicTracao() {
		return mountVeicTracao;
	}

	public void setMountInfVeicTracao(MountVeicTracao mountVeicTracao) {
		this.mountVeicTracao = mountVeicTracao;
	}
	
}
