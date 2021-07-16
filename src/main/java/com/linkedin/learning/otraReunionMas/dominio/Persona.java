package com.linkedin.learning.otraReunionMas.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
