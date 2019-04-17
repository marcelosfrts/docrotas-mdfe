package com.server.mdfe;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="mdfeProc", namespace="http://www.portalfiscal.inf.br/mdfe")
@XmlAccessorType(XmlAccessType.FIELD)
public class MountMdfeProc extends XmlMdfeUtils {

	@XmlAttribute(name="versao")
	private String versao = VERSAO_300;

	@XmlElement(name="MDFe")
	private MountMdfe mountMdfe;

	public MountMdfeProc() {}
	
	public MountMdfeProc(MountMdfe mountMdfe) {
		this.mountMdfe = mountMdfe;
	}

}
