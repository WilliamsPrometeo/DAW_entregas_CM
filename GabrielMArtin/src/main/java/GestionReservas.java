import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

//clase principal que gestiona el menú y el array de reservas
public class GestionReservas {

    //scanner personalizado para la entrada de datos
    private static final MyScanner sc = new MyScanner();

    //array unidimensional para almacenar las reservas que es máximo 30
    private static Reserva[] reservas = new Reserva[30];

    //contador que indica la siguiente posición libre del array
    private static int contador = 0;

    //este es el metodo principal del programa
    public static void main(String[] args) {

        boolean salir;

        //bucle principal del menú
        do {
            salir = false;

            //el menú de las opciones
            int opcion = sc.pedirNumero(
                    " CONTROL DE RESERVAS: " +
                            " 1. Añadir reserva." +
                            " 2. Mostrar todas las reservas." +
                            " 3. Mostrar reservas por año." +
                            " 4. Mostrar reservas por mes." +
                            " 5. Mostrar reservas por rango de años. " +
                            " 6. Salir."
            );

            //estructura switch para gestionar las diferentes opciones
            switch (opcion) {
                case 1:
                    añadirReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    filtrarPorAnio();
                    break;
                case 4:
                    filtrarPorMes();
                    break;
                case 5:
                    filtrarPorRango();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (!salir);
    }

    //añade una nueva reserva al array
    public static void añadirReserva() {

        //solicita el identificador de la reserva
        String id = sc.pideTexto("Introduce el identificador de la reserva:");

        //solicita el nombre del cliente
        String cliente = sc.pideTexto("Introduce el nombre del cliente:");

        //variable para la fecha
        LocalDate fecha = null;
        boolean correcta;

        //bucle para validar la fecha
        do {
            correcta = true;
            try {
                String textoFecha = sc.pideTexto("Introduce la fecha (YYYY-MM-DD):");
                fecha = LocalDate.parse(textoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto");
                correcta = false;
            }
        } while (!correcta);

        //selección del tipo de reserva mediante ENUM
        TipoReserva tipo = Utilidades.pedirEnum(
                TipoReserva.class,
                "Seleccione el tipo de reserva:"
        );

        //vcomprueba si hay espacio en el array
        if (contador < reservas.length) {

            //crea el objeto reserva y lo guarda en el array
            reservas[contador] = new Reserva(id, cliente, fecha, tipo);

            //incrementa el contador
            contador++;

            System.out.println("Reserva añadida correctamente");
        } else {
            System.out.println("No se pueden añadir más reservas");
        }
    }

    //muestra todas las reservas almacenadas
    public static void mostrarReservas() {
        for (int i = 0; i < contador; i++) {
            System.out.println(reservas[i]);
        }
    }

    //muestra las reservas de un año concreto
    public static void filtrarPorAnio() {
        int anio = sc.pedirNumero("Introduce el año:");

        for (int i = 0; i < contador; i++) {
            if (reservas[i].getFechaReserva().getYear() == anio) {
                System.out.println(reservas[i]);
            }
        }
    }

    //muestra las reservas de un mes concretoo
    public static void filtrarPorMes() {
        int mes = sc.pedirNumero("Introduce el mes (1-12):");

        for (int i = 0; i < contador; i++) {
            if (reservas[i].getFechaReserva().getMonthValue() == mes) {
                System.out.println(reservas[i]);
            }
        }
    }

    //muestra las reservas dentro de un rango de años
    public static void filtrarPorRango() {
        int min = sc.pedirNumero("Introduce el año mínimo:");
        int max = sc.pedirNumero("Introduce el año máximo:");

        for (int i = 0; i < contador; i++) {
            int anio = reservas[i].getFechaReserva().getYear();
            if (anio >= min && anio <= max) {
                System.out.println(reservas[i]);
            }
        }
    }
}

