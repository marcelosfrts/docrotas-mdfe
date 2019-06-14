package com.server.mdfe;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="mdfeProc", namespace=MdfeUtils.NAMESPACE_MDFE)
@XmlAccessorType(XmlAccessType.FIELD)
public class MountMdfeProc extends MdfeUtils {

	@XmlAttribute(name="versao")
	private String versao = VERSAO_300;

	@XmlElement(name="MDFe")
	private MountMdfe mountMdfe;

	public MountMdfeProc() {}
	
	public MountMdfeProc(MountMdfe mountMdfe) {
		this.mountMdfe = mountMdfe;
	}

}
