package edu.upc.dsa;

import edu.upc.dsa.models.Personas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Covid19Test {
    @Before
    public void SetUP() {


        Covid19ManagerImpl.getInstance().Vacunacion("p1", "v1", new Date(2020, 01, 5));
        Covid19ManagerImpl.getInstance().Vacunacion("p1", "v1", new Date(2020, 02, 6));
        Covid19ManagerImpl.getInstance().Vacunacion("p1", "v1", new Date(2020, 03, 7));

        Covid19ManagerImpl.getInstance().addSeguimiento("d1", new Date(2020, 03, 05), "p1");
        Covid19ManagerImpl.getInstance().addSeguimiento("d2", new Date(2020, 04, 06), "p2");
        Covid19ManagerImpl.getInstance().addSeguimiento("d3", new Date(2020, 05, 07), "p3");

    }
        @Test
        public void Vacunacion() {
            Covid19ManagerImpl.getInstance().Vacunacion("p1", "v1",new Date(2020,01,20));
            assertEquals(4, Covid19ManagerImpl.getInstance().sizeVacunaciones());
        }


    @Test
    public void addSeguimiento() {
        Covid19ManagerImpl.getInstance().addSeguimiento("dale", new Date(2020,01,05), "p1");
        assertEquals(4, Covid19ManagerImpl.getInstance().sizeSeguimientos());
    }
    @After
    public void tearDown() { Covid19ManagerImpl.getInstance().delete();}
}
