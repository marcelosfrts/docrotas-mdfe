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
@Table(name="pessoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name="ie")
	private String ie;
	
	@Column(name="tp_empresa")
	private boolean ehEmpresa;
	
	@Column(name="tp_condutor")
	private boolean ehCondutor;
	
	@Column(name="tp_seguradora")
	private boolean ehSeguradora;
	
	@Column(name="tp_proprietario")
	private boolean ehProprietário;
	
	@ManyToOne
	@JoinColumn(name="logradouro_id")
	private AddressEntity endereco;

	@Column(name="numero")
	private Long numero;
	
	@ManyToOne
	@JoinColumn(name="bairro_id")
	private NeighborhoodEntity bairro;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private CityEntity cidade;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="fone")
	private Long fone;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public boolean isEhEmpresa() {
		return ehEmpresa;
	}

	public void setEhEmpresa(boolean ehEmpresa) {
		this.ehEmpresa = ehEmpresa;
	}

	public boolean isEhCondutor() {
		return ehCondutor;
	}

	public void setEhCondutor(boolean ehCondutor) {
		this.ehCondutor = ehCondutor;
	}

	public boolean isEhSeguradora() {
		return ehSeguradora;
	}

	public void setEhSeguradora(boolean ehSeguradora) {
		this.ehSeguradora = ehSeguradora;
	}

	public boolean isEhProprietário() {
		return ehProprietário;
	}

	public void setEhProprietário(boolean ehProprietário) {
		this.ehProprietário = ehProprietário;
	}	

	public AddressEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(AddressEntity endereco) {
		this.endereco = endereco;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public NeighborhoodEntity getBairro() {
		return bairro;
	}

	public void setBairro(NeighborhoodEntity bairro) {
		this.bairro = bairro;
	}

	public CityEntity getCidade() {
		return cidade;
	}

	public void setCidade(CityEntity cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getFone() {
		return fone;
	}

	public void setFone(Long fone) {
		this.fone = fone;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", cpfCnpj=" + cpfCnpj + ", ie=" + ie + ", ehEmpresa=" + ehEmpresa
				+ ", ehCondutor=" + ehCondutor + ", ehSeguradora=" + ehSeguradora + ", ehProprietário=" + ehProprietário
				+ ", endereco=" + endereco + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", nome=" + nome + ", fone=" + fone + "]";
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
		PersonEntity other = (PersonEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
