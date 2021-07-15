package com.linkedin.learning.otraReunionMas.dao;

import javax.persistence.Query;

import com.linkedin.learning.otraReunionMas.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion> {

	public ReunionDao() {
		setClazz(Reunion.class);
	}
	
	public Reunion proximaReunion() {
		String qlString = "FROM " + Reunion.class.getName() + " WHERE fecha > now() order by fecha";
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1);
		return (Reunion) query.getSingleResult();
	}
}
