package com.linkedin.learning.otraReunionMas.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.internal.build.AllowSysOut;
//Mapeo de clases

@Entity//Se pone encima del elemento que queremosa anotar, que es la clase
		//Le decimos al sistema de persistencia que esta clase es una entida
		//que tiene que mapear
@Table (name = "reunion")
public class Reunion {
	
	//La tabla tiene 3 columnas, por lo tanto usamos 3  @columns
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "asunto")
	private String asunto;
	
	public Reunion() {
    }
	
	public Reunion(Date fecha, String asunto) {
		this.fecha = fecha;
		this.asunto = asunto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Reunion [id=" + id + ", fecha=" + fecha + ", asunto=" + asunto + "]" + "\n";
	}

}
