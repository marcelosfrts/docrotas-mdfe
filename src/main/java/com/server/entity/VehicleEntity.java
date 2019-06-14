package com.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="veiculo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VehicleEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="tara")
	private Long tara;
	
	@Column(name="capkg")
	private Long capKg;
	
	@Column(name="tprod")
	private TipoRodadoEnum tipoRodado;
	
	@Column(name="tpcar")
	private TipoCarroceriaEnum tipoCarroceria; 
	
	@ManyToOne
	@JoinColumn(name="licenciamento_ufid")
	private StateEntity stateEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getTara() {
		return tara;
	}

	public void setTara(Long tara) {
		this.tara = tara;
	}

	public Long getCapKg() {
		return capKg;
	}

	public void setCapKg(Long capKg) {
		this.capKg = capKg;
	}

	public TipoRodadoEnum getTipoRodado() {
		return tipoRodado;
	}

	public void setTipoRodado(TipoRodadoEnum tipoRodado) {
		this.tipoRodado = tipoRodado;
	}

	public TipoCarroceriaEnum getTipoCarroceria() {
		return tipoCarroceria;
	}

	public void setTipoCarroceria(TipoCarroceriaEnum tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}

	public StateEntity getStateEntity() {
		return stateEntity;
	}

	public void setStateEntity(StateEntity stateEntity) {
		this.stateEntity = stateEntity;
	}

	@Override
	public String toString() {
		return "VehicleEntity [id=" + id + ", placa=" + placa + ", tara=" + tara + ", capKg=" + capKg + ", tipoRodado="
				+ tipoRodado + ", tipoCarroceria=" + tipoCarroceria + ", stateEntity=" + stateEntity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleEntity other = (VehicleEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
