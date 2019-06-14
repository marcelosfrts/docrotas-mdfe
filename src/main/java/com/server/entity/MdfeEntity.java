package com.server.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mdfe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MdfeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="numero")
	private Long numero;
	
	@Column(name="serie")
	private Integer serie;
	
	@Column(name="tipo")
	private Integer tipo;
	
	@Column(name="dv")
	private Integer dv;
	
	@Column(name="modelo")
	private Integer modelo;
	
	@Column(name="dtemissao")
	private Timestamp dtEmissao;
	
	@Column(name="dtencerramento")
	private Timestamp dtEncerramento;
	
	@Column(name="codibgecidadeemitente")
	private String codIbgeCidadeEmitente;
	
	@Column(name="ufcoleta")
	private String ufColeta;
	
	@Column(name="ufentrega")
	private String ufEntrega;
	
	@Column(name="codibgecidadeencerramento")
	private String codIbgeCidadeEncerramento;

	@Column(name="chave")
	private String chave;
	
	@Column(name="codsituacao")
	private Integer codSituacao;
	
	@Column(name="recibo")
	private String recibo;
	
	@ManyToOne
	@JoinColumn(name="empresaid")
	private CompanyEntity empresa;
	
	@Column(name="qtddoc")
	private Long qtdDoc;
	
	@Column(name="vlrcarga")
	private BigDecimal vlrCarga;
	
	@Column(name="qtdcarga")
	private BigDecimal qtdCarga;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="condutor")
	private String condutor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getDv() {
		return dv;
	}

	public void setDv(Integer dv) {
		this.dv = dv;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	public Timestamp getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Timestamp dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Timestamp getDtEncerramento() {
		return dtEncerramento;
	}

	public void setDtEncerramento(Timestamp dtEncerramento) {
		this.dtEncerramento = dtEncerramento;
	}

	public String getCodIbgeCidadeEmitente() {
		return codIbgeCidadeEmitente;
	}

	public void setCodIbgeCidadeEmitente(String codIbgeCidadeEmitente) {
		this.codIbgeCidadeEmitente = codIbgeCidadeEmitente;
	}

	public String getUfColeta() {
		return ufColeta;
	}

	public void setUfColeta(String ufColeta) {
		this.ufColeta = ufColeta;
	}

	public String getUfEntrega() {
		return ufEntrega;
	}

	public void setUfEntrega(String ufEntrega) {
		this.ufEntrega = ufEntrega;
	}

	public String getCodIbgeCidadeEncerramento() {
		return codIbgeCidadeEncerramento;
	}

	public void setCodIbgeCidadeEncerramento(String codIbgeCidadeEncerramento) {
		this.codIbgeCidadeEncerramento = codIbgeCidadeEncerramento;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Integer getCodSituacao() {
		return codSituacao;
	}

	public void setCodSituacao(Integer codSituacao) {
		this.codSituacao = codSituacao;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public CompanyEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(CompanyEntity empresa) {
		this.empresa = empresa;
	}

	public Long getQtdDoc() {
		return qtdDoc;
	}

	public void setQtdDoc(Long qtdDoc) {
		this.qtdDoc = qtdDoc;
	}

	public BigDecimal getVlrCarga() {
		return vlrCarga;
	}

	public void setVlrCarga(BigDecimal vlrCarga) {
		this.vlrCarga = vlrCarga;
	}

	public BigDecimal getQtdCarga() {
		return qtdCarga;
	}

	public void setQtdCarga(BigDecimal qtdCarga) {
		this.qtdCarga = qtdCarga;
	}

	public String getPlaca() {
		return placa;
	}
	
	public String getCondutor() {
		return condutor;
	}

	public void setCondutor(String condutor) {
		this.condutor = condutor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MdfeEntity other = (MdfeEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MdfeEntity [id=" + id + ", numero=" + numero + ", serie=" + serie + ", tipo=" + tipo + ", dv=" + dv
				+ ", modelo=" + modelo + ", dtEmissao=" + dtEmissao + ", dtEncerramento=" + dtEncerramento
				+ ", codIbgeCidadeEmitente=" + codIbgeCidadeEmitente + ", ufColeta=" + ufColeta + ", ufEntrega="
				+ ufEntrega + ", codIbgeCidadeEncerramento=" + codIbgeCidadeEncerramento + ", chave=" + chave
				+ ", codSituacao=" + codSituacao + ", recibo=" + recibo + ", empresa=" + empresa + ", qtdDoc=" + qtdDoc
				+ ", vlrCarga=" + vlrCarga + ", qtdCarga=" + qtdCarga + "]";
	}
}
