package com.server.mdfe;

import javax.xml.bind.annotation.XmlElement;

public class MountSeg {

	private MountInfResp mountInfResp;
	private MountInfSeg mountInfSeg;
	private String nApol;
	private String nAver;
	
	public MountSeg() {}
			
	public MountSeg(MountInfResp mountInfResp, MountInfSeg mountInfSeg, String nApol, String nAver) {
		this.mountInfResp = mountInfResp;
		this.mountInfSeg = mountInfSeg;
		this.nApol = nApol;
		this.nAver = nAver;
	}

	@XmlElement(name="infResp")
	public MountInfResp getMountInfResp() {
		return mountInfResp;
	}

	public void setMountInfResp(MountInfResp mountInfResp) {
		this.mountInfResp = mountInfResp;
	}

	@XmlElement(name="infSeg")
	public MountInfSeg getMountInfSeg() {
		return mountInfSeg;
	}

	public void setMountInfSeg(MountInfSeg mountInfSeg) {
		this.mountInfSeg = mountInfSeg;
	}

	public String getnApol() {
		return nApol;
	}

	public void setnApol(String nApol) {
		this.nApol = nApol;
	}

	public String getnAver() {
		return nAver;
	}

	public void setnAver(String nAver) {
		this.nAver = nAver;
	}
		
}
