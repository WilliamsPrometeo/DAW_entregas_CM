import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestionReservas gestor = new GestionReservas(30);

        int opcion;

        // menú principal
        do {
            System.out.println("\n===== GESTIÓN DE RESERVAS =====");
            System.out.println("1. Añadir reserva");
            System.out.println("2. Filtrar todas");
            System.out.println("3. Filtrar por año");
            System.out.println("4. Filtrar por mes");
            System.out.println("5. Filtrar por rango de años");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: // solicitar datos de la reserva

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre cliente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Año: ");
                    int anio = sc.nextInt();
                    System.out.print("Mes: ");
                    int mes = sc.nextInt();
                    System.out.print("Día: ");
                    int dia = sc.nextInt();
                    sc.nextLine();

                    LocalDate fecha = LocalDate.of(anio, mes, dia);

                    // selecciona el tipo de reserva
                    System.out.println("Tipo (1 INDIVIDUAL, 2 DOBLE, 3 SUITE): ");
                    int tipoOp = sc.nextInt();
                    sc.nextLine();

                    TipoReserva tipo = TipoReserva.INDIVIDUAL;
                    if (tipoOp == 2) tipo = TipoReserva.DOBLE;
                    if (tipoOp == 3) tipo = TipoReserva.SUITE;

                    // crear objeto reserva y añadirlo al gestor
                    Reserva nueva = new Reserva(id, nombre, fecha, tipo);

                    if (gestor.anadirReserva(nueva)) {
                        System.out.println("Reserva añadida.");
                    } else {
                        System.out.println("No hay espacio.");
                    }
                    break;

                case 2:
                    gestor.mostrarTodas();
                    break;

                case 3:
                    System.out.print("Año: ");
                    gestor.filtrarPorAnio(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Mes: ");
                    gestor.filtrarPorMes(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Inicio: ");
                    int inicio = sc.nextInt();
                    System.out.print("Fin: ");
                    int fin = sc.nextInt();
                    gestor.filtrarPorRangoAnios(inicio, fin);
                    break;

                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}

