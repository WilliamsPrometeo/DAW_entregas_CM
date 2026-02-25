package ejercicios.p4.Clases;

import ejercicios.p4.Enum.TipoReserva;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionReserva {
    private static final Reserva[] reservas = new Reserva[30];
    private static final MyScanner sc = new MyScanner();
    
    public static void main(String[] args) {
        int op;
        
        do {
            op = sc.pedirNumero("""
                =====MENU=====
                1. Añadir registros
                2. Mostrar registro
                3. Filtrar por año
                4. Filtrar por mes
                5. Filtrar entre años
                6.Salir
                Escoja una opción:""");
            
            switch (op) {
                case 1:
                    anyadirReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    filtrarPorAnyo();
                    break;
                case 4:
                    filtrarPorMes();
                    break;
                case 5:
                    filtrarEntreAnyos();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no valida!");
                    break;
            }
        } while (op != 6);
    }
    
    public static void anyadirReserva() {
        if (Reserva.getNumReserva() == 30) { //Si el array está lleno no se añaden
            System.out.println("No se pueden añadir más reservas!");
        } else {
            boolean exit = false;
            LocalDate fechaReserva = null;
            
            //Pedimos el nombre del cliente
            String nombreCliente = sc.pedirSoloTexto("Ingrese el nombre del cliente: ");
            
            //Pedimos la fecha de la reserva
            do {
                try {
                    //Pedimos la fecha, y en caso de ser incorrecto el formato lanzamos excepcion y la volvemos a pedir
                    String fecha = sc.pideTexto("Ingrese la fecha de creación de la reserva (yyyy-MM-dd): ");
                    fechaReserva = LocalDate.parse(fecha);
                    exit = true;
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage());
                }
            } while (!exit);
            
            TipoReserva tipoReserva = Utilidades.pedirEnum(TipoReserva.class, "Elija el tipo de reserva: ");
            
            reservas[Reserva.getNumReserva()] = new Reserva(nombreCliente, fechaReserva, tipoReserva);
        }
    }
    
    public static void mostrarReservas() {
        if (Reserva.getNumReserva() == 0) {
            System.out.println("No hay reservas que mostrar");
        } else {
            for (int i = 0; i < Reserva.getNumReserva(); i++) {
                System.out.println(reservas[i]);
            }
        }
    }
    
    public static void filtrarPorAnyo() {
        //Pedimos el año de busqueda
        int year = sc.pedirNumero("Ingrese el año por el que desea filtrar: ");
        
        boolean encontrado = false;
        
        //Revisamos todas las reservas de ese año
        for (int i = 0; i < Reserva.getNumReserva(); i++) {
            if (reservas[i].getFechaReserva().getYear() == year) {
                System.out.println(reservas[i]);
                //Si entramos en el if hemos printeado una reserva, asique encontrado deberá de ser true
                encontrado = true;
            }
        }
        
        //Si no encontramos ninguna reserva mandamos el siguiente mensaje
        if (!encontrado) {
            System.out.println("No se ha encontrado ninguna reserva para ese año");
        }
    }
    
    public static void filtrarPorMes() {
        //Pedimos el mes de búsqueda
        int month = sc.pedirNumero("Ingrese el año por el que desea filtrar: ");
        
        boolean encontrado = false;
        
        //Revisamos todas las reservas de ese mes
        for (int i = 0; i < Reserva.getNumReserva(); i++) {
            if (reservas[i].getFechaReserva().getMonthValue() == month) {
                System.out.println(reservas[i]);
                //Si entramos en el if hemos printeado una reserva, asique encontrado deberá de ser true
                encontrado = true;
            }
        }
        
        //Si no encontramos ninguna reserva mandamos el siguiente mensaje
        if (!encontrado) {
            System.out.println("No se ha encontrado ninguna reserva para ese mes");
        }
    }
    
    public static void filtrarEntreAnyos() {
        //Solicitamos el año por el que empezar
        int minYear = sc.pedirNumero("Ingrese el año por el que empezar a filtrar: ");
        
        //Ponemos el max año en -1 ya que no tiene sentido pedir un año inferior al año 0
        int maxYear = -1;
        
        //Si el segundo año es menos que el primero solicitamos de nuevo hasta que cumpla la condicion
        do {
            maxYear = sc.pedirNumero("Ingrese el año por el que terminar a filtrar (debe de ser mayor que el año por" + " el que desea empezar): ");
        } while (minYear > maxYear);
        
        boolean encontrado = false;
        
        //Buscamos entre los años ingresados
        for (int i = 0; i < Reserva.getNumReserva(); i++) {
            if (reservas[i].getFechaReserva().getYear() >= minYear && reservas[i].getFechaReserva().getYear() <= maxYear) {
                System.out.println(reservas[i]);
                //Si entramos en el if hemos printeado una reserva, asique encontrado deberá de ser true
                encontrado = true;
            }
        }
        
        //Si no se encuentran reservas, printeamos el siguiente mensaje
        if (!encontrado) {
            System.out.println("No se ha encontrado ninguna reserva entre esos años");
        }
    }
}