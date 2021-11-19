package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Publicaciones")
public class Publicacion {
	
	@Id
	private String id;
	private String idbeneficiario;
	private String fechacreacion;
	private Long monto;
	private String descripcion;
	private String duracion;
	private String estado;
	
	public Publicacion() {
		
	}
	public Publicacion(String idbeneficiario, String fechacreacion, Long monto, String descripcion, String duracion,
			String estado) {
		super();
		this.idbeneficiario = idbeneficiario;
		this.fechacreacion = fechacreacion;
		this.monto = monto;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.estado = estado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdbeneficiario() {
		return idbeneficiario;
	}
	public void setIdbeneficiario(String idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}
	public String getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public Long getMonto() {
		return monto;
	}
	public void setMonto(Long monto) {
		this.monto = monto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
