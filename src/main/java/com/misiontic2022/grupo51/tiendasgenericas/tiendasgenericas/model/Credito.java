package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Creditos")
public class Credito {
	
	@Id
	private String id;
	private Long monto;
	private String idbeneficiario;
	private String iddonante;
	private String fechainicio;
	private String fechafin;
	private Long interes;
	
	
	public Credito() {
		
	}
	
	public Credito(Long monto, String idbeneficiario, String iddonante, String fechainicio, String fechafin,
			Long interes) {
		super();
		this.monto = monto;
		this.idbeneficiario = idbeneficiario;
		this.iddonante = iddonante;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.interes = interes;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public String getIdbeneficiario() {
		return idbeneficiario;
	}

	public void setIdbeneficiario(String idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}

	public String getIddonante() {
		return iddonante;
	}

	public void setIddonante(String iddonante) {
		this.iddonante = iddonante;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public Long getInteres() {
		return interes;
	}

	public void setInteres(Long interes) {
		this.interes = interes;
	}

	
	
	
	
	
	
	

}
