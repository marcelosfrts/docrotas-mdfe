package com.server.mdfe;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class MountInfModal {

	private MountRodo mountRodo;
	private String versaoModal;

	public MountInfModal() {}	

	public MountInfModal(MountRodo mountRodo, String versaoModal) {
		this.mountRodo = mountRodo;
		this.versaoModal = versaoModal;
	}

	@XmlElement(name="rodo")
	public MountRodo getMountRodo() {
		return mountRodo;
	}

	public void setMountRodo(MountRodo mountRodo) {
		this.mountRodo = mountRodo;
	}

	@XmlAttribute
	public String getVersaoModal() {
		return versaoModal;
	}

	public void setVersaoModal(String versaoModal) {
		this.versaoModal = versaoModal;
	}	
	
}
