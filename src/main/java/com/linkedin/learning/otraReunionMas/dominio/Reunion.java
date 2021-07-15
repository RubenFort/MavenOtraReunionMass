package com.linkedin.learning.otraReunionMas.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Mapeo de clases

@Entity//Se pone encima del elemento que queremosa anotar, que es la clase
		//Le decimos al sistema de persistencia que esta clase es una entida
		//que tiene que mapear
@Table (name = "reunion")
public class Reunion {
	
	//La tabla tiene 3 columnas, por lo tanto usamos 3  @columns
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "asunto")
	private String asunto;
	
	public Reunion(int id, Date fecha, String asunto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.asunto = asunto;
	}
	
	public int getId() {
		return id;
	}

	public void setAsunto(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	
}
