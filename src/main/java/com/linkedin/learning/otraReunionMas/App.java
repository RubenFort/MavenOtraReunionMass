package com.linkedin.learning.otraReunionMas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import com.linkedin.learning.otraReunionMas.dao.ReunionDao;
import com.linkedin.learning.otraReunionMas.dominio.Reunion;

public class App 
{
    public static void main( String[] args )
    {
        ReunionDao dao = new ReunionDao();
        List<Reunion> reuniones = dao.getAll();
        System.out.println(reuniones);
        
        Reunion reunion = new Reunion(LocalDateTime.now(), "Test");
        System.out.println(reunion);
        dao.save(reunion);
        System.out.println(reunion);
        
        //Date dt = new Date();
        //Date tomorrow2 = new Date(dt.getTime() + (1000 * 60 * 60 * 24)*2);
        Reunion reunion2 = new Reunion(LocalDateTime.now().plus(2, ChronoUnit.DAYS), "Reunión de pasado mañana");
        System.out.println(reunion2);
        dao.save(reunion2);
        try {
        	System.out.println("Tu próxima reunión es " + dao.proximaReunion());
		} catch (NoResultException e) {
			System.out.println("No tienes ninguna reunión a la vista");
		}
        
    }
}
