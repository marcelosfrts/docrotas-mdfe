package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountInfAntt {

	private String rntrc;
	private MountInfCiot mountInfCiot;

	public MountInfAntt() {}
	
	public MountInfAntt(String rntrc, MountInfCiot mountInfCiot) {
		this.rntrc = rntrc;
		this.mountInfCiot = mountInfCiot;
	}

	@XmlElement(name="RNTRC")
	public String getRntrc() {
		return rntrc;
	}

	public void setRntrc(String rntrc) {
		this.rntrc = rntrc;
	}

	@XmlElement(name="infCIOT")
	public MountInfCiot getMountInfCiot() {
		return mountInfCiot;
	}

	public void setMountInfCiot(MountInfCiot mountInfCiot) {
		this.mountInfCiot = mountInfCiot;
	}
		
}
