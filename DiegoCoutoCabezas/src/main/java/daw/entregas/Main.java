package daw.entregas;

import recursos.MyScanner;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        GestorReservas gestor = new GestorReservas(30);

        int opcion = 0;

        //aqui le mostramos al usuario el menu con las opciones
        do {
            System.out.println();
            System.out.println("     MENU RESERVAS");
            System.out.println();
            System.out.println("1. Añadir reserva");
            System.out.println("2. Mostrar todas las reservas");
            System.out.println("3. Filtrar la reserva por año");
            System.out.println("4. Filtrar la reserva por mes");
            System.out.println("5. Filtrar la reserva por rango de años");
            System.out.println("0. Salir del programa");

            opcion = sc.pedirNumero("Elige una opcion:");

            switch (opcion) {
                case 1:
                    añadirReserva(sc, gestor);
                    break;

                case 2:
                    gestor.mostrarTodas();
                    break;

                case 3:
                    int ani = sc.pedirNumero("Introduce el año:");
                    gestor.mostrarPorAnio(ani);
                    break;

                case 4:
                    int mes = sc.pedirNumero("Introduce el mes (1-12):");
                    gestor.mostrarPorMes(mes);
                    break;

                case 5:
                    int inicio = sc.pedirNumero("Año inicial:");
                    int fin = sc.pedirNumero("Año final:");
                    gestor.mostrarRangoAnios(inicio, fin);
                    break;

                case 0:
                    System.out.println();
                    break;

                default:
                    System.out.println("Opcion erronea, Elige otra opcion");
            }

        } while (opcion != 0);

        sc.cerrar();
    }

    private static void añadirReserva(MyScanner sc, GestorReservas gestor) {


        String ident = sc.pideTexto("Introduce el identificador:");
        String nombre = sc.pedirSoloTexto("Introduce el nombre:");

        int ani = sc.pedirNumero("Introduce el año:");
        int mes = sc.pedirNumero("Introduce el mes:");
        int dia = sc.pedirNumero("Introduce el día:");

        LocalDate fecha = LocalDate.of(ani, mes, dia);

        System.out.println("Tipo de reserva:");
        System.out.println("1 Individual");
        System.out.println("2 Doble");
        System.out.println("3 Suite");

        int tipoNumero = sc.pedirNumero("Elige un tipo de habitacion:");

        TipoReserva tipo;
        switch (tipoNumero) {
            case 1:
                tipo = TipoReserva.INDIVIDUAL;
                break;
            case 2:
                tipo = TipoReserva.DOBLE;
                break;
            case 3:
                tipo = TipoReserva.SUITE;
                break;
            default:
                System.out.println("Tipo no válido. Se asigna INDIVIDUAL.");
                tipo = TipoReserva.INDIVIDUAL;
                break;
        }

        Reserva re = new Reserva(ident, nombre, fecha, tipo);
        gestor.agregarReserva(re);
    }
}
