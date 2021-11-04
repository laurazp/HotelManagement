package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Test unitarios para el hotel
 *
 * @author laurazp
 */
public class HotelTest {

    //Instancia del hotel
    private Hotel hotel;
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    //Instancia de cliente
    Cliente cliente = new Cliente("Olivia", "González Reyes", "12877953W");
    
    /**
     * Método constructor del test
     */
    public HotelTest() {
        this.hotel = new Hotel("Sheraton", "Avda. de Las Marismas, s/n", "Lanzarote");
    }

    /**
     * Test del método getNombre de la clase Hotel.
     */
    @Test
    public void testGetNombre() {
        String expected = "Sheraton";
        String result = hotel.getNombre();
        assertEquals(expected, result);
    }

    /**
     * Test del método getDomicilio de la clase Hotel.
     */
    @Test
    public void testGetDomicilio() {
        String expected = "Avda. de Las Marismas, s/n";
        String result = hotel.getDomicilio();
        assertEquals(expected, result);
    }

    /**
     * Test del método getPoblacion de la clase Hotel.
     */
    @Test
    public void testGetPoblacion() {
        String expected = "Lanzarote";
        String result = hotel.getPoblacion();
        assertEquals(expected, result);
    }

    /**
     * Test del método comprobarDniCliente de la clase Hotel.
     */
    @Test
    public void testComprobarDniCliente() {
        String dniCliente = "77469321G";
        boolean expected = false;
        boolean result = hotel.comprobarDniCliente(dniCliente);
        assertEquals(expected, result);
    }

    /**
     * Test del método comprobarHabitacion de la clase Hotel.
     */
    @Test
    public void testComprobarHabitacion() {
        int numeroHab = 103;
        int expected = 1;
        int result = hotel.comprobarHabitacion(numeroHab);
        assertEquals(expected, result);
    }

    /**
     * Test del método listarHabsDisponiblesPorTipo de la clase Hotel.
     */
    @Test
    public void testListarHabsDisponiblesPorTipo() {
        String tipoHab = "";
        LocalDate entrada = null;
        LocalDate salida = null;
        int expected = 0;
        int result = hotel.listarHabsDisponiblesPorTipo(tipoHab, entrada, salida);
        assertEquals(expected, result);
    }
}
