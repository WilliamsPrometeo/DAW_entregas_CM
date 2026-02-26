import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GestionReservas {

        private static final Scanner sc = new Scanner(System.in);
        private static final Reserva[] reservas = new Reserva[30];
        private static int contador = 0;

        public static void main(String[] args) {

            boolean salir = false;

            do  {
                System.out.println("=====GESTION DE RESERVAS=======");
                System.out.println("1. Añadir reserva:");
                System.out.println("2. Mostrar todas las reservas:");
                System.out.println("3. Filtrar por año:");
                System.out.println("4. Filtrar por mes:");
                System.out.println("5. Filtrar por rango de años:");
                System.out.println("6. Salir:");

                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:anadirReserva();
                    break;

                    case 2:mostrarReservas();
                    break;

                    case 3:filtrarPorAnio();
                    break;

                    case 4:filtrarPorMes();
                    break;

                    case 5:filtrarPorRango();
                    break;

                    case 6:salir=true;
                    break;

                    default:System.out.println("Opcion no valida");
                    break;
                }
            }while(!salir);
        }

        private static void anadirReserva() {

            if (contador >= reservas.length) {
                System.out.println("No hay mas espacios para reservas");
                return;
            }

            System.out.print("Identificador: ");
            String id = sc.nextLine();

            System.out.print("Nombre del cliente: ");
            String cliente = sc.nextLine();

            LocalDate fecha = null;
            boolean correcta;

            do {
                correcta = true;
                try {
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    fecha = LocalDate.parse(sc.nextLine());
                }catch(DateTimeParseException e) {
                    System.out.println("Formato de fecha incorrecta");
                    correcta = false;
                }
            }while(!correcta);

            System.out.println("Tipo de reserva: ");
            for (TipoReserva t : TipoReserva.values()) {
                System.out.println("- " + t);
            }

            TipoReserva tipo = TipoReserva.valueOf(sc.nextLine());
            reservas[contador] = new Reserva(id, cliente, fecha, tipo);
            contador++;
        }

        private static void mostrarReservas() {
            for (int i = 0 ; i < contador; i++) {
                System.out.println(reservas[i]);
            }
        }

        private static void filtrarPorAnio() {
            System.out.print("Año: ");
            int anio = sc.nextInt();

            for (int i = 0 ; i < contador; i++) {
                if (reservas[i].getFechaReserva().getYear() == anio) {
                    System.out.println(reservas[i]);
                }
            }
        }

        private static void filtrarPorMes() {
            System.out.print("Mes (1-12): ");
            int mes = sc.nextInt();

            for (int i = 0 ; i < contador; i++) {
                if (reservas[i].getFechaReserva().getMonthValue() == mes) {
                    System.out.println(reservas[i]);
                }
            }
        }

        private static void filtrarPorRango() {
            System.out.print("Año minimo: ");
            int min = sc.nextInt();
            System.out.print("Año maximo: ");
            int max = sc.nextInt();

            for (int i = 0 ; i < contador; i++) {
                int anio = reservas[i].getFechaReserva().getYear();
                if (anio >= min && anio <= max) {
                    System.out.println(reservas[i]);
                }
            }
        }

}
