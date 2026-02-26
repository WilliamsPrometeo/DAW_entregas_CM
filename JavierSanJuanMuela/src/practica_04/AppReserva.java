package practica_04;

// JAVIER SAN JUAN MUELA

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppReserva {
    private static Reserva[] reservas = new Reserva[30];

    private static int contador = 0;

    private static Reserva.TipoReserva[] tipoReservas = Reserva.TipoReserva.values();

    private static final Scanner sc = new Scanner(System.in);

    private static void mostarMenu() {
        System.out.println("=============\nElige una opción:\n1. Añadir Reserva\n2. Mostrar Reservas\n3. Filtrar Reservas\n4. Salir\n=============");
        System.out.print("-> ");
    }

    private static void mostrarReservas() {
        try {
            for (Reserva reserva : reservas) {
                System.out.println(reserva.toString());
            }
        } catch (NullPointerException ignored) {
            // ignora
        }
    }

    private static void anadirReserva() {
        try {
            System.out.print("Nombre del Cliente? -> ");
            String nombre = sc.next();
            System.out.print("Año Reserva? -> ");
            int anoReserva = sc.nextInt();
            System.out.print("Mes Reserva? -> ");
            int mesReserva = sc.nextInt();
            System.out.print("Dia Reserva? -> ");
            int diaReserva = sc.nextInt();
            LocalDate fechaReserva = LocalDate.of(anoReserva, mesReserva, diaReserva);
            System.out.println("Elije el tipo de habitación:\n1. INDIVIDUAL\n2. DOBLE\n3. SUITE");
            System.out.print("-> ");
            int opcion = sc.nextInt();
            try {
                reservas[contador] = new Reserva(String.valueOf(contador + 1), nombre, fechaReserva, tipoReservas[opcion - 1].toString());
                contador++;
                System.out.println("Reserva añadida!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selecciona un tipo de habitación correcta!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Pon un valor numérico.");
        } catch (DateTimeException dateException) {
            System.out.println("Pon fechas válidas!");
        }
    }

    public static void main(String[] args) {
        boolean bucle = true;
        while (bucle) {
            mostarMenu();
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        anadirReserva();
                        break;
                    case 2:
                        mostrarReservas();
                        break;
                    case 3:
                        filtrarFecha();
                        break;
                    case 4:
                        bucle = false;
                        break;
                    default:
                        System.out.println("Selecciona una opción correcta.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Escribe una opción numérica.");
            }
        }

    }

    private static void filtrarFecha() {
        System.out.println("1. Filtrar por Año\n2. Filtrar por mes\n3. Filtrar por rango de años");
        System.out.print("-> ");
        try {
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Año? -> ");
                    int ano = sc.nextInt();
                    filtrarReservasPorAno(ano);
                    break;
                case 2:
                    System.out.print("Mes? -> ");
                    int mes = sc.nextInt();
                    filtrarReservaPorMes(mes);
                    break;
                case 3:
                    System.out.print("Rango años? (Año inicial) -> ");
                    int rangoPrincipio = sc.nextInt();
                    System.out.print("Rango años? (Año final) -> ");
                    int rangoFinal = sc.nextInt();
                    filtrarReservasPorRango(rangoPrincipio, rangoFinal);
                    break;
                default:
                    System.out.println("Pon un filtro correcto.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Pon un valor numérico");
        }
    }

    private static void filtrarReservasPorAno(int ano) {
        try {
            for (int i = 0; i < reservas.length; i++) {
                if (reservas[i].getFechaReserva().getYear() == ano) {
                    System.out.println(reservas[i].toString());
                }
            }
        } catch (NullPointerException ingorar) {
            // ignorar
        }
    }

    private static void filtrarReservaPorMes(int mes) {
        try {
            for (int i = 0; i < reservas.length; i++) {
                if (reservas[i].getFechaReserva().getMonthValue() == mes) {
                    System.out.println(reservas[i].toString());
                }
            }
        } catch (NullPointerException ingorar) {
            // ignorar
        }
    }

    private static void filtrarReservasPorRango(int rangoPrincipio, int rangoFinal) {
        try {
            for (int i = 0; i < reservas.length; i++) {
                if (reservas[i].getFechaReserva().getYear() >= rangoPrincipio && reservas[i].getFechaReserva().getYear() <= rangoFinal) {
                    System.out.println(reservas[i].toString());
                }
            }
        } catch (NullPointerException ingorar) {
            // ignorar
        }
    }


}
