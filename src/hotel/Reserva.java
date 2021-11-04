package hotel;

import java.time.LocalDate;
/**
 * Esta clase define una Reserva que se realiza en el hotel
 * @author laurazp
 */
public class Reserva {
    // Atributos de la clase
    private int numeroReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Cliente cliente;
    private Habitacion habitacion;
    /**
     * Método constructor para las reservas
     */
    public Reserva() {
    }
    /**
     * Método constructor para las reservas
     * @param pNumeroReserva Este parámetro es de tipo int y define el número de la reserva
     * @param pFechaEntrada Este parámetro es de tipo LocalDate y define la fecha de entrada de la reserva
     * @param pFechaSalida Este parámetro es de tipo LocalDate y define la fecha de salida de la reserva
     * @param pCliente Este parámetro es de tipo Cliente y define el cliente al que se le hace la reserva
     * @param pHabitacion Este parámetro es de tipo Habitación y define la habitación adjudicada a la reserva
     */
    public Reserva(int pNumeroReserva, LocalDate pFechaEntrada, LocalDate pFechaSalida, Cliente pCliente, Habitacion pHabitacion) {
        this.numeroReserva = pNumeroReserva;
        this.fechaEntrada = pFechaEntrada;
        this.fechaSalida = pFechaSalida;
        this.cliente = pCliente;
        this.habitacion = pHabitacion;
    }
     /**
     * Método que devuelve el número de la reserva
     * @return Devuelve un int que corresponde al número de la habitación
     */
    public int getNumeroReserva() {
        return this.numeroReserva;
    }
    /**
     * Método que devuelve la fecha de entrada de la reserva
     * @return Devuelve un LocalDate que corresponde a la fecha de entrada de la reserva
     */
    public LocalDate getFechaEntrada() {
        return this.fechaEntrada;
    }
    /**
     * Método que devuelve la fecha de salida de la reserva
     * @return Devuelve un LocalDate que corresponde a la fecha de salida de la reserva
     */
    public LocalDate getFechaSalida() {
        return this.fechaSalida;
    }
    /**
     * Método que devuelve el cliente de la reserva
     * @return Devuelve un tipo Cliente que corresponde al cliente al que se le hace la reserva
     */
    public Cliente getCliente() {
        return this.cliente;
    }
    /**
     * Método que devuelve la habitación adjudicada a la reserva
     * @return Devuelve un tipo Habitación que corresponde a la habitación adjudicada a la reserva
     */
    public Habitacion getHabitacion() {
        return this.habitacion;
    }
    /**
     * Método que permite establecer el número de reserva
     * @param pNumeroReserva Este parámetro es de tipo int y define el número de la reserva
     */
    public void setNumeroReserva(int pNumeroReserva) {
        this.numeroReserva = pNumeroReserva;
    }
    /**
     * Método que permite establecer la fecha de entrada de la reserva
     * @param pFechaEntrada Este parámetro es de tipo LocalDate y define la fecha de entrada de la reserva
     */
    public void setFechaEntrada(LocalDate pFechaEntrada) {
        this.fechaEntrada = pFechaEntrada;
    }
    /**
     * Método que permite establecer la fecha de salida de la reserva
     * @param pFechaSalida Este parámetro es de tipo LocalDate y define la fecha de salida de la reserva
     */
    public void setFechaSalida(LocalDate pFechaSalida) {
        this.fechaSalida = pFechaSalida;
    }
    /**
     * Método que permite establecer el cliente de la reserva
     * @param pCliente Este parámetro es de tipo Cliente y define el cliente de la reserva
     */
    public void setCliente(Cliente pCliente) {
        this.cliente = pCliente;
    }
    /**
     * Método que permite establecer la habitación adjudicada a la reserva
     * @param pHabitacion Este parámetro es de tipo Habitacion y define la habitación adjudicada a la reserva
     */
    public void setHabitacion(Habitacion pHabitacion) {
        this.habitacion = pHabitacion;
    }
    /**
     * Método que permite mostrar la información completa de un objeto de la clase Reserva
     * @return Devuelve un String con todos los datos de la reserva
     */
    @Override
    public String toString() {
        return "Reserva número " + this.getNumeroReserva() + ", Fecha de entrada: " + this.getFechaEntrada() + ", Fecha de salida: " + this.getFechaSalida() + ", Cliente alojado: " + this.getCliente().getDni() + ", Habitación reservada: " + this.getHabitacion().getNumero() + '.';
    }
}
