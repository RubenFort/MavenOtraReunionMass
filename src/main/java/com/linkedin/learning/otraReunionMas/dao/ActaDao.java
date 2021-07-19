package com.linkedin.learning.otraReunionMas.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import com.linkedin.learning.otraReunionMas.dominio.Acta;
import com.linkedin.learning.otraReunionMas.dominio.Reunion;

public class ActaDao extends AbstractDao<Acta>{

	public ActaDao() {
		setClazz(Acta.class);
	}
	
	public List<Acta> findActasReunionesAntiguas() {
		String qlString = "FROM " + Acta.class.getName() + " a WHERE a.reunion.fecha < :ayer";
		
		LocalDateTime ayer = LocalDateTime.now().minusDays(1);
		
		Query query = getEntityManager().createQuery(qlString);
		query.setParameter("ayer", ayer);
		 
		return query.getResultList();
	}
}
