package hotel;
/**
 * Esta clase define una Habitación de tipo Simple que hereda de la clase Habitación
 * @author laurazp
 */
public class Simple extends Habitacion {
    // Atributos de la clase
   private int m2;
   private double precio;
   /**
    * Método constructor para las habitaciones Simples
    * @param pNumero Este parámetro es de tipo int y define el número de la habitación
    * @param pM2 Este parámetro es de tipo int y define los metros cuadrados de la habitación
    * @param pPrecio Este parámetro es de tipo double y define el precio de la habitación
    */
   public Simple(int pNumero, int pM2, double pPrecio) {
       super(pNumero);
       this.m2 = pM2;
       this.precio = pPrecio;
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
    * Método que permite mostrar la información completa de un objeto de la clase Simple
    * @return Devuelve un String con todos los datos de la habitación Simple
    */
    @Override
    public String toString() {
        return "Habitación Simple de " + m2 + " metros, y con un precio de " + precio + " Euros.";
    }
    
    @Override
    public TipoHab getTipoHab() {
        return TipoHab.SIMPLE;
    }
}
