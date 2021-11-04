package hotel;

import static hotel.Habitacion.TipoHab.SIMPLE;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

/**
 * Test unitarios para las Habitaciones.
 * @author laurazp
 */
public class HabitacionTest {
    /** Instancia de la habitación **/
    private Habitacion habitacion101; 

    /**
     * Método constructor del test
     */
    public HabitacionTest() {
        this.habitacion101 = new Simple(101, 11, 62.50);
    }
    
    /**
     * Test del método getNumero de la clase Habitacion.
     */
    @Test
    public void testGetNumero() {
        int expected = 101;
        int result = habitacion101.getNumero();
        assertEquals(expected, result);
    }

    /**
     * Test del método getReservada de la clase Habitacion.
     */
    @Test
    public void testGetReservada() {
        habitacion101.setReservada(true);
        boolean expected = true;
        boolean result = habitacion101.getReservada();
        assertEquals(expected, result);
    }

    /**
     * Test del método getTipoHab de la clase Habitacion.
     */
    @Test
    public void testGetTipoHab() {
        Habitacion.TipoHab expected = SIMPLE;
        Habitacion.TipoHab result = habitacion101.getTipoHab();
        assertEquals(expected, result);
    }

    /**
     * Test del método getTipoHabString de la clase Habitacion.
     */
    @Test
    public void testGetTipoHabString() {
        String expected = "SIMPLE";
        String result = habitacion101.getTipoHabString();
        assertEquals(expected, result);
    }

}
