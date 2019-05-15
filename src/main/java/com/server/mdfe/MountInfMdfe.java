package com.server.mdfe;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"mountIde","mountEmit","mountInfModal","mountInfDoc","mountSeg","mountTot"})
public class MountInfMdfe extends MdfeUtils {

	private String id;
	private String versao = VERSAO_300;	
	private MountIde mountIde;
	private MountEmit mountEmit;
	private MountInfModal mountInfModal;
	private MountInfDoc mountInfDoc;
	private MountSeg mountSeg;
	private MountTot mountTot;

	public MountInfMdfe() {}

	public MountInfMdfe(String id, String versao, MountIde mountIde, MountEmit mountEmit, MountInfModal mountInfModal,
			MountInfDoc mountInfDoc, MountSeg mountSeg, MountTot mountTot) {
		this.id = id;
		this.versao = versao;
		this.mountIde = mountIde;
		this.mountEmit = mountEmit;
		this.mountInfModal = mountInfModal;
		this.mountInfDoc = mountInfDoc;
		this.mountSeg = mountSeg;
		this.mountTot = mountTot;
	}

	@XmlAttribute(name="Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name="versao")	
	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	@XmlElement(name="ide")
	public MountIde getMountIde() {
		return mountIde;
	}

	public void setMountIde(MountIde mountIde) {
		this.mountIde = mountIde;
	}

	@XmlElement(name="emit")
	public MountEmit getMountEmit() {
		return mountEmit;
	}

	public void setMountEmit(MountEmit mountEmit) {
		this.mountEmit = mountEmit;
	}

	@XmlElement(name="infModal")
	public MountInfModal getMountInfModal() {
		return mountInfModal;
	}

	public void setMountInfModal(MountInfModal mountInfModal) {
		this.mountInfModal = mountInfModal;
	}

	@XmlElement(name="infDoc")
	public MountInfDoc getMountInfDoc() {
		return mountInfDoc;
	}

	public void setMountInfDoc(MountInfDoc mountInfDoc) {
		this.mountInfDoc = mountInfDoc;
	}

	@XmlElement(name="seg")
	public MountSeg getMountSeg() {
		return mountSeg;
	}

	public void setMountSeg(MountSeg mountSeg) {
		this.mountSeg = mountSeg;
	}

	@XmlElement(name="tot")
	public MountTot getMountTot() {
		return mountTot;
	}

	public void setMountTot(MountTot mountTot) {
		this.mountTot = mountTot;
	}

}
