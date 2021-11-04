package hotel;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Test unitarios para las Reservas.
 * @author laurazp
 */
public class ReservaTest {
    /** Instancia de la reserva **/
    private Reserva reserva;
    /** Instancias de cliente y habitación Simple **/
    Cliente cliente1 = new Cliente();
    Simple habitacion110 = new Simple(110, 10, 35.50);
    /**
     * Método constructor del test
     */
    public ReservaTest() {
        this.reserva = new Reserva(120, LocalDate.of(2021, 04, 12), LocalDate.of(2021, 04, 18), cliente1, habitacion110);
    }
    
    /**
     * Test del método getNumeroReserva de la clase Reserva.
     */
    @Test
    public void testGetNumeroReserva() {
        int expected = 120;
        int result = reserva.getNumeroReserva();
        assertEquals(expected, result);
    }

    /**
     * Test del método getFechaEntrada de la clase Reserva.
     */
    @Test
    public void testGetFechaEntrada() {
        LocalDate expected = LocalDate.of(2021, 04, 12);
        LocalDate result = reserva.getFechaEntrada();
        assertEquals(expected, result);
    }

    /**
     * Test del método getFechaSalida de la clase Reserva.
     */
    @Test
    public void testGetFechaSalida() {
        LocalDate expected = LocalDate.of(2021, 04, 18);
        LocalDate result = reserva.getFechaSalida();
        assertEquals(expected, result);
    }

    /**
     * Test del método getCliente de la clase Reserva.
     */
    @Test
    public void testGetCliente() {
        Cliente expected = cliente1;
        Cliente result = reserva.getCliente();
        assertEquals(expected, result);
    }

    /**
     * Test del método getHabitacion de la clase Reserva.
     */
    @Test
    public void testGetHabitacion() {
        Habitacion expected = habitacion110;
        Habitacion result = reserva.getHabitacion();
        assertEquals(expected, result);
    }

    /**
     * Test del método toString de la clase Reserva.
     */
    @Test
    public void testToString() {
        String expected = "Reserva número 120, Fecha de entrada: 2021-04-12, Fecha de salida: 2021-04-18, Cliente alojado: null, Habitación reservada: 110.";
        String result = reserva.toString();
        assertEquals(expected, result);
    }
    
}
