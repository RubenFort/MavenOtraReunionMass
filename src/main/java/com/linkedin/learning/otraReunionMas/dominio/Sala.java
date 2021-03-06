package com.linkedin.learning.otraReunionMas.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {

	@Id
	@Column(length = 20)
	private String id;
	private String description;
	private int capacidad;
	
	@OneToMany(mappedBy = "sala")
	private List<Reunion> reuniones;
	
	public Sala() {
	}

	public Sala(String id, String description, int capacidad) {
		this.id = id;
		this.description = description;
		this.capacidad = capacidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public List<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(List<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", description=" + description + ", capacidad=" + capacidad + "]";
	}
}
