package com.linkedin.learning.otraReunionMas;

import java.util.Date;
import java.util.List;
import com.linkedin.learning.otraReunionMas.dao.ReunionDao;
import com.linkedin.learning.otraReunionMas.dominio.Reunion;

public class App 
{
    public static void main( String[] args )
    {
        ReunionDao dao = new ReunionDao();
        List<Reunion> reuniones = dao.getAll();
        System.out.println(reuniones);
        
        Reunion reunion = new Reunion(new Date(), "Test");
        System.out.println(reunion);
        dao.save(reunion);
        System.out.println(reunion);
    }
}
