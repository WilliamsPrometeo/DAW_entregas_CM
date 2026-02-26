package src;

import java.time.LocalDate;

public class ControlReservas {
    private static MyScanner sc = new MyScanner();
    private static Reserva[] reserva = new Reserva[20];
    private static int contador = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.pedirNumero("Indique la opción deseada:");
            switch (opcion) {
                case 1:
                    anyadirReserva();
                    break;
                case 2:
                    mostrarRservas();
                    break;
                case 3:
                    filtrarAnyo();
                    break;
                case 4:
                    filtrarMes();
                    break;
                case 5:
                    filtroRango();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }
        } while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("===Menu===" +
                "\n 1.Hacer una reserva." +
                "\n 2.Mostrar todas las reservas." +
                "\n 3.Filtrar reservas por año" +
                "\n 4.Filtrar reserva por mes" +
                "\n 5.Filtrar reservas por rango de años." +
                "\n 6.Salir.");
    }

    public static void anyadirReserva() {
        LocalDate fechaReserva = null;
        do{
            try {
                String fecha = sc.pideTexto("Introduzca la fecha de la reserva(YYYY-MM-DD)");
                fechaReserva = LocalDate.parse(fecha);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(fechaReserva == null);

        TipoReserva tipo = Utilidades.pedirEnum(TipoReserva.class, "Seleccione el tipo de su reserva:");

        String cliente = sc.pideTexto("Introduzca su nombre: ");

        String id =  "#" + contador;

        if(contador < reserva.length){
            reserva[contador] = new Reserva(id, cliente, fechaReserva, tipo);
            contador++;
        }else
            System.out.println("No se acceptan mas reservas");
    }

    public static void mostrarRservas() {
        for (int i = 0; i < reserva.length; i++) {
            if (reserva[i] != null) {
                System.out.println(reserva[i]);
            }
        }
    }

    public static Reserva RegistroAnyo(int year) {
        for (int i = 0; i < reserva.length ; i++) {
            if (reserva[i].getFechaReserva().getYear() == year) {
                return reserva[i];
            }
        }
        return null;
    }

    public static void filtrarAnyo() {
        int year = sc.pedirNumero("Ingrese año para filtrar: ");
        System.out.println(RegistroAnyo(year));
    }

    public static Reserva RegistroMes(int mes) {
        for (int i = 0; i < reserva.length ; i++) {
            if (reserva[i].getFechaReserva().getYear() == mes) {
                return reserva[i];
            }
        }
        return null;
    }

    public static void filtrarMes() {
        int mes = sc.pedirNumero("Ingrese mes para filtrar: ");
        System.out.println(RegistroMes(mes));
    }

    public static void filtroRango() {
        int min_anyo = sc.pedirNumero("Ingrese año mínimo: ");
        int max_anyo = sc.pedirNumero("Ingrese año máximo: ");
        System.out.println(RangoAnyos(min_anyo, max_anyo));
    }

    public static Reserva RangoAnyos (int min_anyo, int max_anyo) {
        for (int i = 0; i < reserva.length; i++) {
            int anyo = reserva[i].getFechaReserva().getYear();
            if (min_anyo < anyo && anyo > max_anyo) {
                return reserva[i];
            }
        }
        return null;
    }
}