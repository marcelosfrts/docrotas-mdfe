package com.server.mdfe;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class MountMdfe extends XmlMdfeUtils {
	
	@XmlAttribute(name="xmlns")
	private String xmlns = NAMESPACE_MDFE;	
	
	@XmlElement(name="infMDFe")
	private MountInfMdfe mountInfMdfe;

	public MountMdfe(MountInfMdfe mountInfMdfe) {
		this.mountInfMdfe = mountInfMdfe;
	}

	public void setMountInfMdfe(MountInfMdfe mountInfMdfe) {
		this.mountInfMdfe = mountInfMdfe;
	}

}
