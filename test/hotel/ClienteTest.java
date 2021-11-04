package hotel;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Test unitarios para el cliente
 * @author laurazp
 */
public class ClienteTest {
    /** Instancia del cliente **/
    private Cliente cliente;
    /**
     * Método constructor del test
     */
    public ClienteTest() {
        this.cliente = new Cliente("Oscar", "Pérez Ferreiro", "35873235M");
    }

    /**
     * Test del método getDni de Cliente.
     */
    @Test
    public void testGetDni() {
        String expected = "35873235M";
        String result = this.cliente.getDni();
        assertEquals(expected, result);
    }

    /**
     * Test del método getNombre de Cliente.
     */
    @Test
    public void testGetNombre() {
        String expected = "Oscar";
        String result = this.cliente.getNombre();
        assertEquals(expected, result);
    }

    /**
     * Test of getApellidos method, of class Cliente.
     */
    @Test
    public void testGetApellidos() {
        String expected = "Pérez Ferreiro";
        String result = this.cliente.getApellidos();
        assertEquals(expected, result);
    }

    /**
     * Test del método toString de Cliente.
     */
    @Test
    public void testToString() {
        String expected = "Nombre: Oscar. Apellidos: Pérez Ferreiro. DNI: 35873235M.";
        String result = this.cliente.toString();
        assertEquals(expected, result);
    }
    
    /**
     * Test del método equals de Cliente.
     */
    @Test
    public void testEquals() {
        assertTrue(this.cliente.equals(this.cliente));
    }
    
}
