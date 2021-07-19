package com.linkedin.learning.otraReunionMas;

import java.util.List;

import com.linkedin.learning.otraReunionMas.dao.ActaDao;
import com.linkedin.learning.otraReunionMas.dominio.Acta;

public class AppActas {

	public static void main(String[] args) {
		ActaDao actaDao = new ActaDao();
		List<Acta> actasAntiguas = actaDao.findActasReunionesAntiguas();
		System.out.println("Actas antiguas: " + actasAntiguas);
	}
}
