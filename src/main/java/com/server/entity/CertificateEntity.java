package com.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certificado")
public class CertificateEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="idEmpresa")
	private Long idCompany;
	
	@Column(name="caminho")
	private String path;
	
	@Column(name="senha")
	private String pwd;
	
}
