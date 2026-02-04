package Entregas;

import Ejemplos.Tipo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionReservas {

    private static final MyScanner sc = new MyScanner();

    private static Reserva[] reservas = new Reserva[30];
    private static int contador = 0;

    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("-----Registros------" +
                    "\n1. Añadir Reserva" +
                    "\n2. Mostrar Reservas" +
                    "\n3. Mostrar Reserva por año concreto" +
                    "\n4. Mostrar Reserva por mes concreto" +
                    "\n5. Mostrar Reserva por rango de años" +
                    "\n6. Salir" +
                    "\nIngrese la opción:");
            switch (opcion) {
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

        public static void addReserva () {
            boolean correcto;
            LocalDate fechaReserva = null;
            String identificadorReserva = sc.pideTexto("Ingrese el Identificador Reserva: ");
            String Nombre = sc.pideTexto("Ingrese su nombre: ");
            do {
                correcto = true;
                try {
                    String fecha = sc.pideTexto("Ingrese la fecha de Reserva (YYYY-MM-DD): ");
                    fechaReserva = LocalDate.parse(fecha);
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            } while (!correcto);


            TipoReserva tipo = Utilidades.pedirEnum(TipoReserva.class, "Seleccione el tipo de reserva: ");

            if (contador < reservas.length) {
                reservas[contador] = new Reserva(identificadorReserva,Nombre,fechaReserva,tipo);
                contador++;
            } else {
                System.out.println("La lista de reservas ya esta llena.");
            }
    }

            public static void mostrarReservas() {
                for (int i = 0; i < reservas.length; i++) {
                    if (reservas[i] != null) {
                        System.out.println(reservas[i]);
                    }
                }
            }

        public static void filtroYear() {
            int year = sc.pedirNumero("Ingrese el año para filtrar: ");
            System.out.println(obtenerReservaPorAnio(year));
        }

        public static void filtroMonth() {
            int month = sc.pedirNumero("Ingrese el mes para filtrar: ");
            System.out.println(obtenerReservaPorMes(month));
        }

        public static void filtroRango() {
            int min_year = sc.pedirNumero("Ingrese el año mínimo: ");
            int max_year = sc.pedirNumero("Ingrese el año máximo: ");
            System.out.println(obtenerReservaEnRango(min_year, max_year));
        }


        public static Reserva obtenerReservaPorAnio(int year) {
            for (int i = 0; i < reservas.length ; i++) {
                if (reservas[i].getFechaReserva().getYear() == year) {
                    return reservas[i];
                }
            }
            return null;
        }

        public static Reserva obtenerReservaPorMes(int month) {
            for (int i = 0; i < reservas.length; i++) {
                if (reservas[i].getFechaReserva().getMonthValue() == month) {
                    return reservas[i];
                }
            }
            return null;
        }

        public static Reserva obtenerReservaEnRango (int min_year, int max_year) {
            for (int i = 0; i < reservas.length; i++) {
                int year = reservas[i].getFechaReserva().getYear();
                if (min_year < year && year > max_year) {
                    return reservas[i];
                }
            }
            return null;
        }
}

