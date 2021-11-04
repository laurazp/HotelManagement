package hotel;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Esta clase define un Hotel
 * @author laurazp
 */
public class Hotel {
    // Atributos de la clase
    private String nombre;
    private String domicilio;
    private String poblacion;
    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final ArrayList<Reserva> listaReservas = new ArrayList<>();
    private final ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();
    
    /**
     * Método constructor para los hoteles
     */
    public Hotel() {
    }
    
    /**
     * Método constructor para los hoteles
     *
     * @param pNombre Este parámetro es de tipo String y define el nombre del
     * hotel
     * @param pDomicilio Este parámetro es de tipo String y define el domicilio
     * del hotel
     * @param pPoblacion Este parámetro es de tipo String y define la población
     * del hotel
     */
    public Hotel(String pNombre, String pDomicilio, String pPoblacion) {
        this.nombre = pNombre;
        this.domicilio = pDomicilio;
        this.poblacion = pPoblacion;
    }

    /**
     * Método que devuelve el nombre del hotel
     *
     * @return Devuelve un String que corresponde al nombre del hotel
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que permite establecer el nombre del hotel
     *
     * @param pNombre Este parámetro es de tipo String y define el nombre del
     * hotel
     */
    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }

    /**
     * Método que devuelve el domicilio del hotel
     *
     * @return Devuelve un String que corresponde al domicilio del hotel
     */
    public String getDomicilio() {
        return this.domicilio;
    }

    /**
     * Método que permite establecer el domicilio del hotel
     *
     * @param pDomicilio Este parámetro es de tipo String y define el domicilio
     * del hotel
     */
    public void setDomicilio(String pDomicilio) {
        this.domicilio = pDomicilio;
    }

    /**
     * Método que devuelve la población del hotel
     *
     * @return Devuelve un String que corresponde a la población del hotel
     */
    public String getPoblacion() {
        return this.poblacion;
    }

    /**
     * Método que permite establecer la población del hotel
     *
     * @param pPoblacion Este parámetro es de tipo String y define la población
     * del hotel
     */
    public void setPoblacion(String pPoblacion) {
        this.poblacion = pPoblacion;
    }

    // Funciones de la aplicación
    /**
     * Función que lanza el menú de inicio de la app
     */
    public void inicio() {
        String volver;
        do {
            // Imprimir opciones del menú
            System.out.println("Elija una opción:\n 1 - Añadir Cliente\n 2 - Añadir Habitación\n 3 - Crear Reserva\n 4 - Imprimir un listado\n");
            Scanner sc = new Scanner(System.in);
            int opciones = sc.nextInt();
            // Menú de opciones
            switch (opciones) {
                case 1:
                    pedirDatosCliente();
                    break;
                case 2:
                    pedirDatosHabitacion();
                    break;
                case 3:
                    crearReserva();
                    break;
                case 4:
                    imprimirListado();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            // Preguntamos si se quiere volver al menú de inicio
            System.out.println("\n");
            sc.nextLine();
            System.out.println("¿Desea volver al menú de inicio? Pulse S para SI || Pulse N para NO");
            volver = sc.nextLine();
        } while (!"N".equals(volver));
    }

    /**
     * Función para introducir los datos de los clientes y guardarlos en la lista de clientes del hotel
     */
    public void pedirDatosCliente() {
        String repetir;
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        do {
            // Se pide el DNI del nuevo cliente y se lee con nextLine() que retorna un String
            System.out.println("Por favor introduzca el DNI del cliente");
            String dniCliente = sc.nextLine();

            // Se comprueba que no se añadan dos clientes con el mismo DNI 
            boolean encontrado = comprobarDniCliente(dniCliente);

            if (encontrado == true) {
                System.out.println("Ya existe un cliente con ese DNI");
            } else {
                // Se piden el resto de datos del cliente
                System.out.println("Por favor introduzca el nombre del cliente");
                String nombreCliente = sc.nextLine();

                System.out.println("Por favor introduzca los apellidos del cliente");
                String apellidosCliente = sc.nextLine();

                // Como el cliente no existe, se crea
                Cliente nuevoCliente = new Cliente(nombreCliente, apellidosCliente, dniCliente);
                // Se añade al ArrayList
                listaClientes.add(nuevoCliente);
                // Y se imprimen por consola sus datos
                System.out.println("Nuevo cliente introducido con éxito.");
                System.out.println(nuevoCliente.toString());
            }

            // Se pregunta si se quieren introducir más clientes
            System.out.println("\n");
            System.out.println("¿Desea introducir otro cliente? Pulse S para SI || Pulse N para NO");
            repetir = sc.nextLine();
        } while (!"N".equals(repetir));
    }

    /**
     * Función para pedir los datos de la habitación que se quiere crear
     */
    public void pedirDatosHabitacion() {
        String repetir;
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Elija el tipo de habitación que quiere introducir:\n 1 - Simple\n 2 - Doble\n 3 - Suite\n");
            String respuesta = sc.nextLine();
            int opciones = Integer.parseInt(respuesta);

            // Menú de opciones
            switch (opciones) {
                case 1:
                    crearSimple();
                    break;
                case 2:
                    crearDoble();
                    break;
                case 3:
                    crearSuite();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            opciones = 0;
            // Se pregunta si se quieren introducir más clientes
            System.out.println("\n");
            System.out.println("¿Desea introducir otra habitación? Pulse S para SI || Pulse N para NO");
            repetir = sc.nextLine();
        } while ((!"N".equals(repetir)));
    }

    /**
     * Función para crear una reserva y añadirla a la lista de reservas del hotel
     */
    public void crearReserva() {
        String repetir;
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        do {
            // Se piden las fechas de la reserva y el tipo de habitación deseada
            System.out.println("Por favor introduzca la fecha de entrada");
            LocalDate fechaEntrada = agregarFecha();

            System.out.println("Por favor introduzca la fecha de salida");
            LocalDate fechaSalida = agregarFecha();

            System.out.println("Por favor introduzca el tipo de habitación que desea (SIMPLE, DOBLE o SUITE)");
            String tipoH = sc.nextLine();

            // Se busca si hay habitaciones disponibles en esas fechas
            System.out.println("Existen las siguientes habitaciones disponibles del tipo deseado:");
            for (int i = 0; i < listaHabitaciones.size(); i++) {
                if (listaHabitaciones.get(i).getTipoHabString().equals(tipoH) && listaHabitaciones.get(i).getReservada() == false) {
                    System.out.println(listaHabitaciones.get(i).toString());
                }
            }

            // Se crea una nueva reserva
            Reserva nuevaReserva = new Reserva();
            // Se adjudica un número de reserva, que irá aumentando de manera automática
            int numeroRes = 0;
            if (!listaReservas.isEmpty()) {
                for (int j = 0; j < listaReservas.size(); j++) {
                    numeroRes = nuevaReserva.getNumeroReserva();
                }
            }
            numeroRes += 1;

            // Se adjudica una habitación a la reserva
            for (int i = 0; i < listaHabitaciones.size(); i++) {
                if (listaHabitaciones.get(i).getTipoHabString().equals(tipoH) && listaHabitaciones.get(i).getReservada() == false) {
                    nuevaReserva.setHabitacion(listaHabitaciones.get(i));
                }
                break;
            }

            // Se pide el DNI del cliente que se alojará
            System.out.println("Por favor introduzca el DNI del cliente que se va a alojar");
            String dniCliente = sc.nextLine();

            // Se añaden los datos a la reserva
            nuevaReserva.setFechaEntrada(fechaEntrada);
            nuevaReserva.setFechaSalida(fechaSalida);
            nuevaReserva.setCliente(getClienteByDni(dniCliente));
            nuevaReserva.setNumeroReserva(numeroRes);

            // Se añade la reserva creada al ArrayList de reservas del hotel
            listaReservas.add(nuevaReserva);
            // Se añade la reserva creada al ArrayList de reservas del cliente
            nuevaReserva.getCliente().addReservaCliente(nuevaReserva);

            // Y se imprimen por consola sus datos
            System.out.println("La reserva ha sido realizada con éxito.");
            System.out.println(nuevaReserva.toString());

            // Se pregunta si se quieren crear más reservas
            System.out.println("\n");
            System.out.println("¿Desea crear otra reserva? Pulse S para SI || Pulse N para NO");
            repetir = sc.nextLine();
        } while (!"N".equals(repetir));
    }

    /**
     * Función para lanzar el menú de listados de la app
     */
    public void imprimirListado() {
        String repetir;
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nElija el listado que quiere imprimir:\n 1 - Habitaciones disponibles por tipo de habitación en un período determinado\n 2 - Reservas realizadas en un período determinado\n 3 - Reservas por clientes en un período determinado\n");
            String respuesta = sc.nextLine();
            int opciones = Integer.parseInt(respuesta);

            // Menú de opciones
            switch (opciones) {
                case 1:
                    // Pedimos el tipo de habitación
                    System.out.println("\nEscriba en mayúsculas el tipo de habitación que quiere consultar: SIMPLE, DOBLE o SUITE");
                    String tipoHab = sc.nextLine();
                    // Pedimos las fechas en las que buscar
                    System.out.println("\n----- Especifique las fechas en las que quiere buscar -----");
                    System.out.println("Fecha de inicio:");
                    LocalDate entrada = agregarFecha();
                    System.out.println("\nFecha de fin:");
                    LocalDate salida = agregarFecha();
                    listarHabsDisponiblesPorTipo(tipoHab, entrada, salida);
                    break;
                case 2:
                    listarReservasPeriodo();
                    break;
                case 3:
                    listarReservasPorCliente();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            opciones = 0;
            // Se pregunta si se quieren introducir más clientes
            System.out.println("\n");
            System.out.println("¿Desea imprimir otro listado? Pulse S para SI || Pulse N para NO");
            repetir = sc.nextLine();
        } while ((!"N".equals(repetir)));
    }

    /**
     * Función para comprobar si el cliente ya existe en la base de datos del hotel
     * @param dniCliente Este parámetro es de tipo String y define el DNI del cliente que se quiere comprobar
     * @return Devuelve un boolean que será true si el cliente ya se encuentra dado de alta en el hotel, o false si no existe ningún cliente en el hotel con ese DNI
     */
    public boolean comprobarDniCliente(String dniCliente) {
        boolean encontrado = false;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDni().equals(dniCliente)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    /**
     * Función para crear una nueva habitación de tipo Simple y añadirla a la lista de habitaciones del hotel
     */
    public void crearSimple() {
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        // Se pide el número de la nueva habitación y se lee con nextInt() que retorna un entero
        System.out.println("Por favor introduzca el número de la habitación");
        int numeroHab = sc.nextInt();

        // Llamamos a la función crearHabitacion() que comprobará que no exista ya una habitación con ese número
        int creada = comprobarHabitacion(numeroHab);

        if (creada != 0) {
            // Se piden el resto de datos de la habitación Simple
            System.out.println("Por favor introduzca los metros cuadrados de la habitación");
            int m2 = sc.nextInt();

            System.out.println("Por favor introduzca el precio de la habitación");
            float precio = sc.nextFloat();

            // Como la habitación no existe, se crea
            Simple nuevaHabitacionSimple = new Simple(numeroHab, m2, precio);
            // Se añade al ArrayList
            listaHabitaciones.add(nuevaHabitacionSimple);
            // Y se imprimen por consola sus datos
            System.out.println("Nueva habitación introducida con éxito.");
            System.out.println("Número de habitación: " + numeroHab + ". " + nuevaHabitacionSimple.toString());
        }
    }

    /**
     * Función para crear una nueva habitación de tipo Doble y añadirla a la lista de habitaciones del hotel
     */
    public void crearDoble() {
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        // Se pide el número de la nueva habitación y se lee con nextInt() que retorna un entero
        System.out.println("Por favor introduzca el número de la habitación");
        int numeroHab = sc.nextInt();

        // Llamamos a la función crearHabitacion() que comprobará que no exista ya una habitación con ese número
        int creada = comprobarHabitacion(numeroHab);

        if (creada != 0) {
            // Se piden el resto de datos de la habitación Doble
            System.out.println("Por favor introduzca los metros cuadrados de la habitación");
            int m2 = sc.nextInt();

            System.out.println("Por favor introduzca el precio de la habitación");
            float precio = sc.nextFloat();

            // Como la habitación no existe, se crea
            Doble nuevaHabitacionDoble = new Doble(numeroHab, m2, precio);

            // Se pregunta el tipo de cama
            asignarTipoCama(nuevaHabitacionDoble);

            // Se añade la habitación al ArrayList
            listaHabitaciones.add(nuevaHabitacionDoble);
            // Y se imprimen por consola sus datos
            System.out.println("Nueva habitación introducida con éxito.");
            System.out.println("Habitación doble número " + numeroHab + ": " + nuevaHabitacionDoble.toString());
        }
    }

    /**
     * Función para crear una nueva habitación de tipo Suite y añadirla a la lista de habitaciones del hotel
     */
    public void crearSuite() {
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        // Se pide el número de la nueva habitación y se lee con nextInt() que retorna un entero
        System.out.println("Por favor introduzca el número de la habitación");
        int numeroHab = sc.nextInt();

        // Llamamos a la función crearHabitacion() que comprobará que no exista ya una habitación con ese número
        int creada = comprobarHabitacion(numeroHab);

        if (creada != 0) {
            // Se piden el resto de datos de la habitación Suite
            System.out.println("Por favor introduzca los metros cuadrados del dormitorio");
            int m2Dormitorio = sc.nextInt();

            System.out.println("Por favor introduzca los metros cuadrados de la sala");
            int m2Sala = sc.nextInt();

            System.out.println("Por favor introduzca el precio de la habitación");
            float precio = sc.nextFloat();

            // Como la habitación no existe, se crea
            Suite nuevaHabitacionSuit = new Suite(numeroHab, m2Dormitorio, m2Sala, precio);
            // Se añade al ArrayList
            listaHabitaciones.add(nuevaHabitacionSuit);
            // Y se imprimen por consola sus datos
            System.out.println("Nueva habitación introducida con éxito.");
            System.out.println("Habitación tipo suite número " + numeroHab + ": " + nuevaHabitacionSuit.toString());
        }
    }

    /**
     * Función que comprueba si existe ya una habitación creada con el número dado
     * @param numeroHab Este parámetro es de tipo int y define el número de la habitación
     * @return Devuelve 0 si ya existe una habitación con ese número, o 1 si no existe ninguna habitación con ese número
     */
    public int comprobarHabitacion(int numeroHab) {
        int creada;
        boolean encontrado = false;

        // Se comprueba que no exista una habitación con ese número 
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            if (listaHabitaciones.get(i).getNumero() == numeroHab) {
                encontrado = true;
            }
        }

        if (encontrado == true) {
            System.out.println("Ya existe una habitación con ese número");
            creada = 0;
        } else {
            creada = 1;
        }
        return creada;
    }

    /**
     * Función para asignar el tipo de cama en una habitación doble
     * @param habitacionDoble Este parámetro es de tipo Doble y define la habitación Doble a la que se quiere asignar una cama
     */
    public void asignarTipoCama(Doble habitacionDoble) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduzca el tipo de cama");
        System.out.println("\t0-DOS CAMAS.  1-MATRIMONIO.  2-LITERA");
        String eleccion = sc.nextLine();
        switch (eleccion) {
            case "0":
                habitacionDoble.setTipoCama(Doble.TipoCama.DOSCAMAS);
                break;
            case "1":
                habitacionDoble.setTipoCama(Doble.TipoCama.MATRIMONIO);
                break;
            case "2":
                habitacionDoble.setTipoCama(Doble.TipoCama.LITERA);
                break;
            default:
                System.out.println("Tipo de cama incorrecto.");
                break;
        }
    }

    /**
     * Función que pide un día, un mes y un año y devuelve la fecha como LocalDate
     * @return Devuelve un LocalDate que corresponde a la fecha que se ha introducido por teclado
     */
    public LocalDate agregarFecha() {
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el día (con formato DD):");
        int dia = sc.nextInt();
        System.out.println("Introduce el mes (con formato MM):");
        int mes = sc.nextInt();
        System.out.println("Introduce el año (con formato YYYY):");
        int anyo = sc.nextInt();

        return LocalDate.of(anyo, mes, dia);
    }

    /**
     * Función que busca un DNI en la lista de clientes del hotel y devuelve el cliente al que pertenece ese DNI
     * @param pDni Este parámetro es de tipo String y define el DNI del cliente que se quiere buscar
     * @return Devuelve el cliente al que pertenece el DNI dado y es de tipo Cliente
     */
    public Cliente getClienteByDni(String pDni) {
        Cliente cliente = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDni().equals(pDni)) {
                cliente = listaClientes.get(i);
            }
        }
        return cliente;
    }

    /**
     * Función para imprimir un listado de habitaciones disponibles por tipo de habitación en una fecha determinada
     * @param tipoHab Este parámetro es de tipo String y define el tipo de habitación del que se quiere imprimir el listado: SIMPLE, DOBLE o SUITE
     * @param entrada Este parámetro es de tipo LocalDate y define la fecha de inicio del listado que se desea imprimir
     * @param salida Este parámetro es de tipo LocalDate y define la fecha final del listado que se desea imprimir
     * @return Devuelve un int que corresponde al número de habitaciones disponibles del tipo dado en las fechas seleccionadas
     */
    public int listarHabsDisponiblesPorTipo(String tipoHab, LocalDate entrada, LocalDate salida) {
        // Creamos la variable para el número de habitaciones disponibles y la inicializamos a 0
        int numHabsDisponibles = 0;

        for (int i = 0; i < listaHabitaciones.size(); i++) {
            // Comprobamos si coincide el tipo de habitación
            if (listaHabitaciones.get(i).getTipoHabString().equals(tipoHab)) {
                
                // Si existen reservas en el array de reservas, recorreremos ese array
                if (!listaReservas.isEmpty()) {
                    boolean habLibre = true;
                    for (int j = 0; j < listaReservas.size(); j++) {
                        // Si la habitación coincide con la habitación de la reserva
                        if (listaReservas.get(j).getHabitacion().equals(listaHabitaciones.get(i))) {
                            // Comprobamos si la habitación no está reservada en esas fechas
                            if (comprobarFechasReserva(entrada, salida, listaReservas.get(j))) {
                                habLibre = false;
                            }
                        }
                    }
                    if (habLibre) {
                        System.out.println("La habitacion " + listaHabitaciones.get(i).getTipoHabString() + " número " + listaHabitaciones.get(i).getNumero() + " está disponible.");
                        numHabsDisponibles++;
                    }
                } // Si no hay reservas en el array, entonces todas las habitaciones estarán disponibles
                else {
                    System.out.println("La habitacion " + listaHabitaciones.get(i).getTipoHabString() + " número " + listaHabitaciones.get(i).getNumero() + " está disponible.");
                    numHabsDisponibles++;
                }
            }
        }
        if (numHabsDisponibles == 0) {
            System.out.println("No existe ninguna habitación disponible de ese tipo en las fechas señaladas.");
        }
        return numHabsDisponibles;
    }

    /**
     * Función para imprimir un listado de reservas en un periodo determinado
     */
    public void listarReservasPeriodo() {
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);

        // Pedimos las fechas en las que buscar
        System.out.println("----- Especifique las fechas en las que quiere buscar -----\n");
        System.out.println("Fecha de inicio:\n");
        LocalDate entrada = agregarFecha();
        System.out.println("\nFecha de fin:\n");
        LocalDate salida = agregarFecha();

        // Recorremos el array de reservas y mostramos los resultados
        if (!listaReservas.isEmpty()) {
            System.out.println("--- Reservas realizadas en las fechas seleccionadas ---");
            boolean encontrado = comprobarDisponibilidadReserva(listaReservas, entrada, salida);
            if (!encontrado) {
                System.out.println("No existe ninguna reserva realizada durante ese período.");
            }
        } else {
            System.out.println("No existe ninguna reserva en nuestra base de datos.");
        }
    }

    /**
     * Función para comprobar si existen reservas en el array de reservas del hotel que coincidan con unas fechas dadas
     * @param listaReservas Este parámetro es un ArrayList de tipo Reserva y define el array de reservas del hotel
     * @param entrada Este parámetro es de tipo LocalDate y define la fecha de entrada dada
     * @param salida Este parámetro es de tipo LocalDate y define la fecha de salida dada
     * @return Devuelve un boolean que indica si se han encontrado reservas que coincidan con las fechas dadas (true) o no se ha encontrado ninguna (false)
     */
    public boolean comprobarDisponibilidadReserva(ArrayList<Reserva> listaReservas, LocalDate entrada, LocalDate salida) {
        boolean encontrado = false;
        // Recorremos el array de reservas del hotel
        for (int i = 0; i < listaReservas.size(); i++) {
            // Si coinciden las fechas de alguna reserva con las fechas dadas
            if(comprobarFechasReserva(entrada, salida, listaReservas.get(i))) {
                encontrado = true;
                System.out.println(listaReservas.get(i));
            }
        }
        return encontrado;
    }

    /**
     * Función para comprobar si coinciden las fechas de una reserva del array de reservas, con unas fechas dadas
     * @param entradaSolicitada Este parámetro es de tipo LocalDate y define la fecha de entrada dada
     * @param salidaSolicitada Este parámetro es de tipo LocalDate y define la fecha de salida dada
     * @param reserva Este parámetro es de tipo Reserva y define la reserva que se quiere comprobar
     * @return Devuelve un boolean que indica si coinciden las fechas dadas con las de la reserva comprobada (true) o no coinciden (false)
     */
    public boolean comprobarFechasReserva(LocalDate entradaSolicitada, LocalDate salidaSolicitada, Reserva reserva) {
        boolean encontrado = false;
        // Si alguna de las fechas de entrada y/o salida coinciden en el rango buscado
        if ((reserva.getFechaEntrada().compareTo(entradaSolicitada) >= 0) && (reserva.getFechaSalida().compareTo(salidaSolicitada) <= 0)) {
            encontrado = true;
        } else if ((reserva.getFechaSalida().compareTo(entradaSolicitada) >= 0) && (reserva.getFechaSalida().compareTo(salidaSolicitada) <= 0)) {
            encontrado = true;
        } else if ((reserva.getFechaEntrada().compareTo(entradaSolicitada) >= 0) && (reserva.getFechaEntrada().compareTo(salidaSolicitada) <= 0)) {
            encontrado = true;
        } else if ((reserva.getFechaEntrada().compareTo(entradaSolicitada) <= 0) && (reserva.getFechaSalida().compareTo(salidaSolicitada) >= 0)) {
            encontrado = true;
        }
        return encontrado;
    }

    /**
     * Función para imprimir un listado de reservas por cliente en un periodo determinado
     */
    public void listarReservasPorCliente() {
        // Se crea un nuevo objeto Scanner
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        Cliente cliente = null;
        //ArrayList<Reserva> reservasCliente = new ArrayList<>();

        // Pedimos el DNI del cliente que se desea
        System.out.println("Introduzca el DNI del cliente sobre el que desea conocer las reservas realizadas:");
        String dniCliente = sc.nextLine();

        // Buscamos ese dni en el array de clientes del hotel "listaClientes"
        for (int j = 0; j < listaClientes.size(); j++) {
            // Si encuentra al cliente
            if (listaClientes.get(j).getDni().equals(dniCliente)) {
                cliente = listaClientes.get(j);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            // Recorremos el array de reservas de ese cliente
            if (!cliente.getReservasCliente().isEmpty()) {
                // Pedimos las fechas en las que buscar
                System.out.println("----- Especifique las fechas en las que quiere buscar -----\n");
                System.out.println("Fecha de inicio:\n");
                LocalDate entrada = agregarFecha();
                System.out.println("\nFecha de fin:\n");
                LocalDate salida = agregarFecha();
                // Imprimimos las reservas que coincidan con las fechas seleccionadas
                System.out.println("--- Reservas realizadas en las fechas seleccionadas ---");
                boolean reservaEncontrada = comprobarDisponibilidadReserva(cliente.getReservasCliente(), entrada, salida);
                if (!reservaEncontrada) {
                    System.out.println("No existe ninguna reserva de ese cliente en las fechas seleccionadas.");
                }
            } else {
                System.out.println("No existe ninguna reserva de ese cliente en nuestra base de datos.");
            }
        } else {
            System.out.println("Ese DNI no corresponde a ningún cliente del hotel.");
        }

    }

    /**
     * Función para añadir una reserva al array de reservas en la función main (sólo para pruebas en la función main)
     * @param pReserva Este parámetro es de tipo Reserva y define una reserva que se añade a la lista de reservas
     */
    public void incluirReserva(Reserva pReserva) {
        listaReservas.add(pReserva);
    }

    /**
     * Función para añadir un cliente al array de clientes en la función main (sólo para pruebas en la función main)
     * @param pCliente Este parámetro es de tipo Cliente y define un cliente que se añade a la lista de clientes
     */
    public void incluirCliente(Cliente pCliente) {
        listaClientes.add(pCliente);
    }

    /**
     * Función para añadir una habitación al array de habitaciones en la función main (sólo para pruebas en la función main)
     * @param pHabitacion Este parámetro es de tipo Habitación y define una habitación que se añade a la lista de habitaciones
     */
    public void incluirHabitacion(Habitacion pHabitacion) {
        listaHabitaciones.add(pHabitacion);
    }
    
}
