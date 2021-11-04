package hotel;

import java.time.LocalDate;
/**
 * Clase main de la aplicación
 * @author laurazp
 *
 */
public class App {
    /**
     * Método main
     * @param args Argumentos del programa
     */
    public static void main(String[] args) {
        
        // Inicio Prueba 
        Hotel miHotel = new Hotel();
        
        // Ejemplos de Reservas, Clientes y Habitaciones creados
        Cliente cliente1 = new Cliente("Luis", "González Del Monte", "1234M");
        Cliente cliente2 = new Cliente("Chloe", "Campos Ruiz", "5678C");
        Cliente cliente3 = new Cliente("Darío", "López Cortés", "2222M");
        
        miHotel.incluirCliente(cliente1);
        miHotel.incluirCliente(cliente2);
        miHotel.incluirCliente(cliente3);
        
        Simple habitacion101 = new Simple(101, 10, 35.50);
        Doble habitacion102 = new Doble(102, 9, 32.55);
        Suite habitacion103 = new Suite(103, 7, 5, 35.50);
        Suite habitacion104 = new Suite(104, 8, 6, 39.50);
        
        miHotel.incluirHabitacion(habitacion101);
        miHotel.incluirHabitacion(habitacion102);
        miHotel.incluirHabitacion(habitacion103);
        miHotel.incluirHabitacion(habitacion104);
 
        Reserva reserva1 = new Reserva(123, LocalDate.of(2021, 04, 12), LocalDate.of(2021, 04, 18), cliente1, habitacion101);
        Reserva reserva5 = new Reserva(127, LocalDate.of(2021, 04, 12), LocalDate.of(2021, 04, 18), cliente1, habitacion103);
        Reserva reserva2 = new Reserva(124, LocalDate.of(2021, 04, 05), LocalDate.of(2021, 04, 15), cliente2, habitacion102);
        Reserva reserva3 = new Reserva(125, LocalDate.of(2021, 03, 02), LocalDate.of(2021, 03, 17), cliente3, habitacion103);
        Reserva reserva4 = new Reserva(126, LocalDate.of(2021, 03, 02), LocalDate.of(2021, 03, 17), cliente1, habitacion102);
        
        cliente1.addReservaCliente(reserva1);
        cliente1.addReservaCliente(reserva4);
        cliente1.addReservaCliente(reserva5);
        
        miHotel.incluirReserva(reserva1);
        miHotel.incluirReserva(reserva2);
        miHotel.incluirReserva(reserva3);
        miHotel.incluirReserva(reserva4);
        
        // Fin ejemplos
        
        
        miHotel.inicio();
        // Fin prueba
    }
}

