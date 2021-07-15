package com.linkedin.learning.otraReunionMas.dao;

import com.linkedin.learning.otraReunionMas.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion> {

	public ReunionDao() {
		setClazz(Reunion.class);
	}
}
