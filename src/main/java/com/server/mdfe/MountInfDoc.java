package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountInfDoc {
	
	private MountInfMunDescarga mountInfMunDescarga;

	public MountInfDoc() {}
	
	public MountInfDoc(MountInfMunDescarga mountInfMunDescarga) {
		this.mountInfMunDescarga = mountInfMunDescarga;
	}

	@XmlElement(name="infMunDescarga")
	public MountInfMunDescarga getMountInfMunDescarga() {
		return mountInfMunDescarga;
	}

	public void setMountInfMunDescarga(MountInfMunDescarga mountInfMunDescarga) {
		this.mountInfMunDescarga = mountInfMunDescarga;
	}
	
}
