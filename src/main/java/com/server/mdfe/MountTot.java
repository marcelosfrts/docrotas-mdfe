package com.server.mdfe;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"qCTe","vCarga","cUnid","qCarga"})
public class MountTot {

	private Integer qCTe;
	private BigDecimal vCarga;
	private String cUnid;
	private BigDecimal qCarga;

	public MountTot() {}
	
	public MountTot(Integer qCTe, BigDecimal vCarga, String cUnid, BigDecimal qCarga) {
		this.qCTe = qCTe;
		this.vCarga = vCarga;
		this.cUnid = cUnid;
		this.qCarga = qCarga;
	}

	public Integer getqCTe() {
		return qCTe;
	}

	public void setqCTe(Integer qCTe) {
		this.qCTe = qCTe;
	}

	public BigDecimal getvCarga() {
		return vCarga;
	}

	public void setvCarga(BigDecimal vCarga) {
		this.vCarga = vCarga;
	}

	public String getcUnid() {
		return cUnid;
	}

	public void setcUnid(String cUnid) {
		this.cUnid = cUnid;
	}

	public BigDecimal getqCarga() {
		return qCarga;
	}

	public void setqCarga(BigDecimal qCarga) {
		this.qCarga = qCarga;
	}

}
