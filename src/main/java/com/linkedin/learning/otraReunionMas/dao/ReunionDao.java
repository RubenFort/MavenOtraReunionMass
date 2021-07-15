package com.linkedin.learning.otraReunionMas.dao;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
	
	public List<Reunion> reunionesManana() {
		String qlString = "FROM " + Reunion.class.getName() + " Where fecha between ?1 and ?2";
		Query query =  getEntityManager().createQuery(qlString);
		LocalDate manana = LocalDate.now().plus(1, ChronoUnit.DAYS);
		query.setParameter(1, manana.atStartOfDay());
		query.setParameter(2, manana.plus(1, ChronoUnit.DAYS).atStartOfDay());
		return query.getResultList();
	}
}
