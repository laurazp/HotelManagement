package hotel;
/**
 * Esta clase define una Habitación de tipo Suite que hereda de la clase Habitación
 * @author laurazp
 */
public class Suite extends Habitacion {
    // Atributos de la clase
    private int m2Dormitorio;
    private int m2Sala;
    private double precio;
    /**
     * Método constructor para las habitaciones Suite
     * @param pNumero Este parámetro es de tipo int y define el número de la habitación
     * @param pM2Dormitorio Este parámetro es de tipo int y define los metros cuadrados del dormitorio
     * @param pM2Sala Este parámetro es de tipo int y define los metros cuadrados de la sala
     * @param pPrecio Este parámetro es de tipo double y define el precio de la habitación
     */
    public Suite(int pNumero, int pM2Dormitorio, int pM2Sala, double pPrecio) {
        super(pNumero);
        this.m2Dormitorio = pM2Dormitorio;
        this.m2Sala = pM2Sala;
        this.precio = pPrecio;
    }
    /**
     * Método que devuelve los metros cuadrados del dormitorio
     * @return Devuelve un int que corresponde a los metros cuadrados del dormitorio
     */
    public int getM2Dormitorio() {
        return this.m2Dormitorio;
    }
    /**
     * Método que permite establecer o cambiar los metros cuadrados del dormitorio
     * @param pM2Dormitorio Este parámetro es de tipo int y define los metros cuadrados del dormitorio
     */
    public void setM2Dormitorio(int pM2Dormitorio) {
        this.m2Dormitorio = pM2Dormitorio;
    }
    /**
     * Método que devuelve los metros cuadrados de la sala
     * @return Devuelve un int que corresponde a los metros cuadrados de la sala
     */
    public int getM2Sala() {
        return this.m2Sala;
    }
    /**
     * Método que permite establecer o cambiar los metros cuadrados de la sala
     * @param pM2Sala Este parámetro es de tipo int y define los metros cuadrados de la sala
     */
    public void setM2Sala(int pM2Sala) {
        this.m2Sala = pM2Sala;
    }
    /**
     * Método que devuelve el precio de la habitación
     * @return Devuelve un double que corresponde al precio de la habitación
     */
    public double getPrecio() {
        return this.precio;
    }
    /**
     * Método que permite establecer o cambiar el precio de la habitación
     * @param pPrecio Este parámetro es de tipo double y define el precio de la habitación
     */
    public void setPrecio(double pPrecio) {
        this.precio = pPrecio;
    }
    /**
    * Método que permite mostrar la información completa de un objeto de la clase Suite
    * @return Devuelve un String con todos los datos de la habitación Suite
    */
    @Override
    public String toString() {
        return "Habitación tipo Suite con dormitorio de " + m2Dormitorio + " metros" + ", sala de " + m2Sala + " metros, y con un precio de " + precio + " Euros.";
    }
    
    @Override
    public TipoHab getTipoHab() {
        return TipoHab.SUITE;
    }
}
