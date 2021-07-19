package com.linkedin.learning.otraReunionMas;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.linkedin.learning.otraReunionMas.dao.PersonaDao;
import com.linkedin.learning.otraReunionMas.dominio.Acta;
import com.linkedin.learning.otraReunionMas.dominio.Persona;
import com.linkedin.learning.otraReunionMas.dominio.Reunion;
import com.linkedin.learning.otraReunionMas.dominio.Sala;

public class AppTodoPersona {

	public static void main(String[] args) {
		PersonaDao personaDao = new PersonaDao();
		
		Optional<Persona> optPersona = personaDao.get(1);
		if (optPersona.isPresent()) {//Comprobamos si hay una persona o no
			Persona p = optPersona.get();
			System.out.println("Persona: " + p);
			
			Set<Reunion> reuniones = p.getReuniones();
			System.out.println("Reuniones: " + reuniones);
			
			Set<Sala> salas = new HashSet();
			Set<Persona> participantes = new HashSet();
			Set<Acta> actas = new HashSet();
			for (Reunion reunion : reuniones) {
				salas.add(reunion.getSala());
				participantes.addAll(reunion.getParticipantes());
				actas.add(reunion.getActa());
			}
			System.out.println("Salas: " + salas);
			System.out.println("Participantes: " + participantes);
			System.out.println("Actas: " + actas);
		}
	}
}
