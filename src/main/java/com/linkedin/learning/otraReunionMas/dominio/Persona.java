package com.linkedin.learning.otraReunionMas.dominio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)//Valor de columna no se puede repetir, evita registar 2 veces al mismo empleado
	private String numeroEmpleado;
	
	private String nombre;
	private String apellidos;
	
	@ManyToMany
	private Set<Reunion> reuniones;
	
	public Persona() {
	}

	public Persona(String numeroEmpleado, String nombre, String apellidos) {
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Set<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(Set<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", apellidos="
				+ apellidos + "]";
	}
}
