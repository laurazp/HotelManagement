package hotel;
/**
 * Esta clase define una Habitación de tipo Doble que hereda de la clase Habitación
 * @author laurazp
 */
public class Doble extends Habitacion {
    // Atributos de la clase
    private int m2;
    private double precio;
    private TipoCama tipoCama = TipoCama.DOSCAMAS;
    // Definición del enumerador para el tipo de cama de la habitación
    public enum TipoCama {DOSCAMAS, MATRIMONIO, LITERA}
    /**
     * Método constructor para las habitaciones Dobles
     * @param pNumero Este parámetro es de tipo int y define el número de la habitación
     * @param pM2 Este parámetro es de tipo int y define los metros cuadrados de la habitación
     * @param pPrecio Este parámetro es de tipo double y define el precio de la habitación
     */
    public Doble(int pNumero, int pM2, double pPrecio) {
        super(pNumero);
        this.m2 = pM2;
        this.precio = pPrecio;
    }
    /**
     * Método constructor para las habitaciones Dobles
     * @param pNumero Este parámetro es de tipo int y define el número de la habitación
     * @param pM2 Este parámetro es de tipo int y define los metros cuadrados de la habitación
     * @param pPrecio Este parámetro es de tipo double y define el precio de la habitación
     * @param pTipoCama Este parámetro es del tipo enumerado tipoCama y define el tipo de cama que hay en la habitación
     */
    public Doble(int pNumero, int pM2, double pPrecio, TipoCama pTipoCama) {
        super(pNumero);
        this.m2 = pM2;
        this.precio = pPrecio;
        this.tipoCama = pTipoCama;
    }
    /**
     * Método que devuelve los metros cuadrados de la habitación
     * @return Devuelve un int que corresponde a los metros cuadrados de la habitación
     */
    public int getM2() {
        return this.m2;
    }
    /**
     * Método que permite establecer o cambiar los metros cuadrados de la habitación
     * @param pM2 Este parámetro es de tipo int y define los metros cuadrados de la habitación
     */
    public void setM2(int pM2) {
        this.m2 = pM2;
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
     * Método que devuelve el tipo de cama de la habitación
     * @return Devuelve un tipoCama que corresponde al tipo de cama que tiene la habitación
     */
    public TipoCama getTipoCama() {
        return this.tipoCama;
    }
    /**
     * Método que permite establecer o cambiar el tipo de cama de la habitación
     * @param pTipo Este parámetro es del tipo enumerado tipoCama y define el tipo de cama que hay en la habitación
     */
    public void setTipoCama(TipoCama pTipo) {
        this.tipoCama = pTipo;
    }
    /**
    * Método que permite mostrar la información completa de un objeto de la clase Doble
    * @return Devuelve un String con todos los datos de la habitación Doble
    */
    @Override
    public String toString() {
        return "Habitación Doble de " + m2 + " metros, con un precio de " + precio + " Euros y con cama de tipo " + tipoCama + ".";
    }
    
    @Override
    public TipoHab getTipoHab() {
        return TipoHab.DOBLE;
    }
}
