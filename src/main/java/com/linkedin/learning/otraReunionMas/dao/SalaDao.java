package com.linkedin.learning.otraReunionMas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.linkedin.learning.otraReunionMas.dominio.Sala;

public class SalaDao extends AbstractDao<Sala>{

	public SalaDao() {
		setClazz(Sala.class);
	}

	public List<Sala> findSalaPanaNViejo(int num) {
		String qlString = "FROM " + Sala.class.getName() + " WHERE capacidad >= ?1";
		Query query = getEntityManager().createQuery(qlString);
		query.setParameter(1, num);
		return query.getResultList();
	}
	
	public List<Sala> findSalaPanaN(int num) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Sala> criteriaQuery = cb.createQuery(Sala.class);
		Root<Sala> root = criteriaQuery.from(Sala.class);
		//  first argument is greater than or equal to the second
		criteriaQuery.select(root).where(cb.ge(root.get("capacidad"), num));
		Query query = getEntityManager().createQuery(criteriaQuery);
		return query.getResultList();
	}
}
