package com.linkedin.learning.otraReunionMas;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import com.linkedin.learning.otraReunionMas.dao.ActaDao;
import com.linkedin.learning.otraReunionMas.dao.ReunionDao;
import com.linkedin.learning.otraReunionMas.dao.SalaDao;
import com.linkedin.learning.otraReunionMas.dominio.Acta;
import com.linkedin.learning.otraReunionMas.dominio.Persona;
import com.linkedin.learning.otraReunionMas.dominio.Reunion;
import com.linkedin.learning.otraReunionMas.dominio.Sala;

import jdk.nashorn.internal.objects.NativeWeakMap;

public class App 
{
    public static void main( String[] args ) throws SQLIntegrityConstraintViolationException
    {
        ReunionDao reunionDao = new ReunionDao();
        List<Reunion> reuniones = reunionDao.getAll();
        System.out.println(reuniones);
        
        Persona juan = new Persona("E001h", "Juan", "López");
        Persona ana = new Persona("E002h", "Ana", "Gómez");
        
        Set<Persona> equipo = new HashSet<>();
        equipo.add(juan);
        equipo.add(ana);
        
        Reunion reunion = new Reunion(LocalDateTime.now(), "Test");
        System.out.println(reunion);
        
        reunion.setParticipantes(equipo);
        reunionDao.save(reunion);
        System.out.println(reunion);
        
        ActaDao actaDao = new ActaDao();
        Acta acta = new Acta("Reunion anulada", reunion);
        actaDao.save(acta);
        
        Reunion reunion1 = new Reunion(LocalDateTime.now(),"Otra reunión de Test");
        reunionDao.save(reunion1);
        
        Set<Reunion> reunionesJuan = new HashSet<>();
        Set<Reunion> reunionesAna = new HashSet<>();
        reunionesJuan.add(reunion);
        reunionesAna.add(reunion);
        reunionesAna.add(reunion1);
        
        //Date dt = new Date();
        //Date tomorrow2 = new Date(dt.getTime() + (1000 * 60 * 60 * 24)*2);
        Reunion reunion2 = new Reunion(LocalDateTime.now().plus(2, ChronoUnit.DAYS), "Reunión de pasado mañana");
        System.out.println(reunion2);
        reunionDao.save(reunion2);
        try {
        	System.out.println("Tu próxima reunión es " + reunionDao.proximaReunion());
		} catch (NoResultException e) {
			System.out.println("No tienes ninguna reunión a la vista");
		}
        
        Reunion reunion3 = new Reunion(LocalDateTime.now().plus(1, ChronoUnit.DAYS), "Reunion de mañana");
        reunionDao.save(reunion3);
        List<Reunion> reunionesManana = reunionDao.reunionesManana();
        System.out.println("Para mañana: " + reunionesManana);
        
        SalaDao salaDao = new SalaDao();
        
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        
        Sala sala = new Sala("206", "Sala principal conferencias realeza", 2000);
        
        try {
        	salaDao.save(sala);
		} catch (Exception e) {
			System.out.println("Ya existe una sala con el mismo id");
		}
        
        System.out.println("Paso 1 " + salaDao.getAll());
        
        sala.setDescription("Sala principal reformada");
        salaDao.update(sala);
        
        System.out.println("Paso 2 " + salaDao.getAll());
        
        Sala sala2 = new Sala("45", "Sala de meditación", 1);
        
        salaDao.save(sala2);
        
        System.out.println("Paso 3 " + salaDao.getAll());
        
        salaDao.delete(sala2);
        
        System.out.println("Paso 4 " + salaDao.getAll());
        
    }
}
