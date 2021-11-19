package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Donantes")
public class Donante {
	@Id
	private String id;	
	private String naturaleza;
	private String tipodocumento;
	private String documento;
	private String nombrecompleto;
	private String email;
	private String password;
	
	public Donante() {
		// TODO Auto-generated constructor stub
	}
	
	public Donante(String naturaleza, String tipodocumento, String documento, String nombrecompleto, String email,
			String password, String celular) {
		super();
		this.naturaleza = naturaleza;
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombrecompleto = nombrecompleto;
		this.email = email;
		this.password = password;
		this.celular = celular;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaturaleza() {
		return naturaleza;
	}

	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	private String celular;
	
	


}
