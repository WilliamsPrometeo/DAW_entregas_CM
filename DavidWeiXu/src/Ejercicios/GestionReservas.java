package Ejercicios;

import Clases.Reserva;
import Recursos.MyScanner;
import Recursos.Utilidades;
import enums.TipoReserva;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionReservas {
    private static final MyScanner sc = new MyScanner();

    private static Reserva[] Reservas = new Reserva[30];
    private static int contador = 0;

    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("-----Reservas------" +
                    "\n1. Añadir reserva" +
                    "\n2. Mostrar todas las reservas" +
                    "\n3. Filtrar por año" +
                    "\n4. Filtrar por mes" +
                    "\n5. Filtrar por rango" +
                    "\n6. Salir" +
                    "\nIngrese la opción:");
            switch (opcion){
                case 1:
                    addReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    filtroYear();
                    break;
                case 4:
                    filtroMonth();
                    break;
                case 5:
                    filtroRango();
                    break;
                case 6:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }

        } while (!exit);
    }

    // Metodo para añadir reservas
    public static void addReserva() {
        boolean correcto;
        LocalDate fecha_creacion = null;
        do {
            correcto = true;
            try {
                String fecha = sc.pideTexto("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
                fecha_creacion = LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        TipoReserva tipo_Reserva = Utilidades.pedirEnum(TipoReserva.class, "Seleccione el tipo de Reserva: ");

        String nombreCliente = sc.pideTexto("Ingrese el nombre del cliente: ");

        if (contador < Reservas.length) {
            Reservas[contador] = new Reserva(nombreCliente, fecha_creacion, tipo_Reserva);
            contador++;
        } else {
            System.out.println("La lista de Reservas ya está llena.\n");
        }
    }

    // Metodo que muestra todas las reservas
    public static void mostrarReservas() {
        int nulos=0;
        for (int i = 0; i < Reservas.length; i++) {
            if (Reservas[i] != null) {
                System.out.println(Reservas[i]);
            }
            if (Reservas[i] == null){
                nulos++;
            }
        }
        if (nulos == Reservas.length){
            System.out.println("No se ha añadido ninguna reserva aun!\n");
        } else {
            // Solo es para añadir un salto de espacio despues de imprimir las reservas
            System.out.println();
        }
    }

    // Filtro por año
    public static void filtroYear() {
        int year = sc.pedirNumero("Ingrese el año para filtrar: ");
        if (obtenerReservaPorYear(year)!=null){
            System.out.println(obtenerReservaPorYear(year)+"\n");
        } else {
            System.out.println("No hay reservas que cumplan con el filtro!\n");
        }

    }

    // Filtro por mes
    public static void filtroMonth() {
        int month = sc.pedirNumero("Ingrese el mes para filtrar: ");
        if (obtenerReservaPorMonth(month)!=null){
            System.out.println(obtenerReservaPorMonth(month)+"\n");
        } else {
            System.out.println("No hay reservas que cumplan con el filtro!\n");
        }

    }

    // Filtro por rango de año
    public static void filtroRango() {
        int min_year = sc.pedirNumero("Ingrese el año mínimo: ");
        int max_year = sc.pedirNumero("Ingrese el año máximo: ");
        if(obtenerReservaEnRango(min_year,max_year)!=null){
            System.out.println(obtenerReservaEnRango(min_year, max_year)+"\n");
        } else{
            System.out.println("No hay reservas que cumplan con el filtro!\n");
        }
    }

    // Metodo que nos devuelve las reservas que cumplan con el filtro por año
    public static Reserva obtenerReservaPorYear(int year)  {
        for (int i = 0; i < Reservas.length ; i++) {
            if (Reservas[i]!=null && Reservas[i].getFechaReserva().getYear() == year) {
                return Reservas[i];
            }
        }
        return null;
    }

    // Metodo que nos devuelve las reservas que cumplan con el filtro por mes
    public static Reserva obtenerReservaPorMonth(int month) {
        for (int i = 0; i < Reservas.length; i++) {
            if (Reservas[i] != null && Reservas[i].getFechaReserva().getMonthValue() == month) {
                return Reservas[i];
            }
        }
        return null;
    }

    // Metodo que nos devuelve las reservas que cumplan con el filtro de rango de años
    public static Reserva obtenerReservaEnRango (int min_year, int max_year) {
        for (int i = 0; i < Reservas.length; i++) {
            if (Reservas[i] != null){
                int year = Reservas[i].getFechaReserva().getYear();
                if (min_year <= year && year <= max_year) {
                    return Reservas[i];
                }
                }
            }
        return null;
    }
}

