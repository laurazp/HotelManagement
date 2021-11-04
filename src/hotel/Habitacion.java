package hotel;

import java.util.ArrayList;
/**
 * Esta clase abstracta define una Habitación del hotel, que podrá ser de tipo Simple, Doble o Suite
 * @author laurazp
 */
public abstract class Habitacion {
    // Atributos de la clase
    private int numero;
    private boolean reservada;
    private final ArrayList<Reserva> reservasHabitacion = new ArrayList<>();
    // Definición del enumerador para el tipo de habitación
    public enum TipoHab {SIMPLE, DOBLE, SUITE};
    /**
     * Método constructor para las habitaciones
     */
    public Habitacion() {
    }
    /**
     * Método constructor para las habitaciones
     * @param pNumero Este parámetro es de tipo int y define el número de la habitación
     */
    public Habitacion(int pNumero) {    
        this.numero = pNumero;
        this.reservada = false;
    }
    /**
     * Método que permite establecer el número de habitación
     * @param pNumero Este parámetro es de tipo int y define el número de la habitación
     */
    public void setNumero(int pNumero) {
        this.numero = pNumero;
    }
    /**
     * Método que permite establecer si la habitación está reservada
     * @param pReservada Este parámetro es de tipo boolean y define si la habitación está reservada
     */
    public void setReservada(boolean pReservada) {
        this.reservada = pReservada;
    }
    /**
     * Método que devuelve el número de la habitación
     * @return Devuelve un int que corresponde al número de la habitación
     */
    public int getNumero() {
        return this.numero;
    }
    /**
     * Método que devuelve si la habitación está reservada
     * @return Devuelve un boolean que corresponde a si la habitación está reservada o no
     */
    public boolean getReservada() {
        return this.reservada;
    }
    /**
     * Método que devuelve el tipo de habitación
     * @return Devuelve un tipo enumerado tipoHab que corresponde al tipo de habitación
     */
    public TipoHab getTipoHab() {
        return TipoHab.SIMPLE;
    }
    /**
     * Método que devuelve el tipo de habitación en forma de String
     * @return Devuelve un String que corresponde al tipo de habitación
     */
    public String getTipoHabString() {
        String pTipo = null;
        if(this.getTipoHab().equals(TipoHab.SIMPLE)) {
            pTipo = "SIMPLE";
        }
        if(this.getTipoHab().equals(TipoHab.DOBLE)) {
            pTipo = "DOBLE";
        }
        if(this.getTipoHab().equals(TipoHab.SUITE)) {
            pTipo = "SUITE";
        }
        return pTipo;
    }
}
