package daw.entregas;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class GestionReserva {
    private static final MyScanner sc = new MyScanner();
    
    private static Reserva[] registros = new Reserva[50];
    private static int contador = 0;
    
    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("-----Reservas------" + "\n1. Añadir Reserva" + "\n2. Mostrar todas las reservas" + "\n3. Filtrar reservas por año" + "\n4. Filtrar reservas por mes" + "\n5. Filtrar reservas por rango de años" + "\n6. Salir" + "\nIngrese la opción");
            switch (opcion) {
                case 1:
                    addReserva();
                    break;
                case 2:
                    MostrarReserva();
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
        
        TipoReserva tipo_reserva = Utilidades.pedirEnum(TipoReserva.class, "Escoja el tipo de habitación: ");
        
        String contenido = sc.pideTexto("Ingrese el contenido de la reserva: ");
        
        if (contador < Reserva.length) {
            Reserva[contador] = new Reserva(Reserva, tipo_reserva, contenido);
            contador++;
        } else {
            System.out.println("La lista de registros ya esta llena.");
        }
    }
    
    public static void MostrarReserva() {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                System.out.println(registros[i]);
            }
        }
    }
    public static void filtroYear() {
        int year = sc.pedirNumero("Ingrese el año para filtrar: ");
        System.out.println(obtenerReservaPorAnio()(year));
    }
    
    public static void filtroMonth() {
        int month = sc.pedirNumero("Ingrese el mes para filtrar: ");
        System.out.println(obtenerReservaPorMes(month));
    }
    
    public static void filtroRango() {
        int min_year = sc.pedirNumero("Ingrese el año mínimo: ");
        int max_year = sc.pedirNumero("Ingrese el año máximo: ");
        System.out.println(obtenerRegistroEnRango(min_year, max_year));
    }
    
    public static Reserva obtenerReservaPorAnio(int year) {
        for (int i = 0; i < registros.length ; i++) {
            if (registros[i].getFechaReserva().getYear() == year) {
                return registros[i];
            }
        }
        return null;
    }
    
    public static void obtenerReservaPorMes(int month) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i].getFechaReserva().getMonthValue() == month) {
                System.out.println(registros[i]);
            }
        }
    }
    
    public static Reserva obtenerRegistroEnRango (int min_year, int max_year) {
        for (int i = 0; i < registros.length; i++) {
            int year = registros[i].getFechaReserva().getYear();
            if (min_year < year && year > max_year) {
                return registros[i];
            }
        }
        return null;
    }
}

    
   