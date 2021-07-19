package com.linkedin.learning.otraReunionMas.dao;

import com.linkedin.learning.otraReunionMas.dominio.Persona;

public class PersonaDao extends AbstractDao<Persona>{

	public PersonaDao() {
		setClazz(Persona.class);
	}
}
