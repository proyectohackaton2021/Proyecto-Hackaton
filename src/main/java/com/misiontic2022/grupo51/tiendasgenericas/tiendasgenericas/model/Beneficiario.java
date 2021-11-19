package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Beneficiarios")
public class Beneficiario {
	
	@Id
	private String id;
	private String tipodocumento;
	private String documento;
	private String nombrecompleto;
	private String fechanacimiento;
	private String email;
	private String password;
	
	private String celular;
	
	
	public Beneficiario() {
		
	}


	public Beneficiario(String tipodocumento, String documento, String nombrecompleto, String fechanacimiento,
			String email, String password, String celular) {
		super();
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombrecompleto = nombrecompleto;
		this.fechanacimiento = fechanacimiento;
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


	public String getFechanacimiento() {
		return fechanacimiento;
	}


	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
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
	
	
	
	
	
	
	
	
	

}
