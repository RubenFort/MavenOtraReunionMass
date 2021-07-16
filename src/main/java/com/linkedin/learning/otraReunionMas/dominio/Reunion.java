package com.linkedin.learning.otraReunionMas.dominio;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@Column(name = "id")//Nombre de la columna en la BD
	private int id;
	@Column(name = "fecha")
	private LocalDateTime fecha;
	@Column(name = "asunto")
	private String asunto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Sala sala;
	
	@OneToOne(mappedBy = "reunion")
	private Acta acta;
	
	public Reunion() {
    }
	
	public Reunion(LocalDateTime fecha, String asunto) {
		this.fecha = fecha;
		this.asunto = asunto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public Acta getActa() {
		return acta;
	}

	public void setActa(Acta acta) {
		this.acta = acta;
	}

	@Override
	public String toString() {
		return "Reunion [id=" + id + ", fecha=" + fecha + ", asunto=" + asunto + "]" + "\n";
	}
}
