package hotel;

import java.util.ArrayList;
/**
 * Esta clase define un Cliente del hotel
 * @author laurazp
 */
public class Cliente {
    // Atributos de la clase
    private String nombre;
    private String apellidos;
    private String dni;
    private final ArrayList<Reserva> reservasCliente = new ArrayList<>();
    /**
     * Método constructor para los clientes
     */
    public Cliente() {
    }
    /**
     * Método constructor para los clientes
     * @param pNombre Este parámetro es de tipo String y define el nombre del cliente
     * @param pApellidos Este parámetro es de tipo String y define los apellidos del cliente
     * @param pDni Este parámetro es de tipo String y define el DNI del cliente
     */
    public Cliente(String pNombre, String pApellidos, String pDni) {
        this.nombre = pNombre;
        this.apellidos = pApellidos;
        this.dni = pDni;
    }
    /**
     * Método que permite establecer el nombre del cliente
     * @param pNombre Este parámetro es de tipo String y define el nombre del cliente
     */
    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }
    /**
     * Método que permite establecer los apellidos del cliente
     * @param pApellidos Este parámetro es de tipo String y define los apellidos del cliente
     */
    public void setApellidos(String pApellidos) {
        this.apellidos = pApellidos;
    }
    /**
     * Método que permite establecer el DNI del cliente
     * @param pDni Este parámetro es de tipo String y define el DNI del cliente
     */
    public void setDni(String pDni) {
        this.dni = pDni;
    }
    /**
     * Método que devuelve el nombre del cliente
     * @return Devuelve un String que corresponde al nombre del cliente
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Método que devuelve los apellidos del cliente
     * @return Devuelve un String que corresponde a los apellidos del cliente
     */
    public String getApellidos() {
        return this.apellidos;
    }
    /**
     * Método que devuelve el DNI del cliente
     * @return Devuelve un String que corresponde al DNI del cliente
     */
    public String getDni() {
        return this.dni;
    }
    /**
     * Método que devuelve el array de reservas del cliente
     * @return Devuelve un ArrayList de Reservas que corresponde a la lista de reservas del cliente
     */
    public ArrayList<Reserva> getReservasCliente() {
        return this.reservasCliente;
    }
    /**
     * Método para añadir reservas a un cliente
     * @param pReserva Este parámetro es de tipo Reserva y define una reserva que realiza un cliente
     */
    public void addReservaCliente(Reserva pReserva) {
        reservasCliente.add(pReserva);
    }
    /**
     * Método para imprimir una lista de las reservas que ha realizado un cliente
     */
    public void listReservas() {
        for (int i = 0; i < reservasCliente.size(); i++) {
            System.out.println("reservasCliente.get(i).toString()");
        }
    }
    /**
     * Método que permite mostrar la información completa de un objeto de la clase Cliente
     * @return Devuelve un String con todos los datos del cliente
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ". Apellidos: " + apellidos + ". DNI: " + dni + ".";
    }
}
