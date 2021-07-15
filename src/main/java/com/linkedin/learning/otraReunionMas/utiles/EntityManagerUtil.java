package com.linkedin.learning.otraReunionMas.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager getEntityManager() {
		//Crear factoria
		//Poner mismo nombre que se le dio a la unidad de persistencia en el fichero de configuración persistence.xml "OtraReunionMas"
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
		//Pedimos gestor de entidades
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public static void main(String[] args) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
	}
}
