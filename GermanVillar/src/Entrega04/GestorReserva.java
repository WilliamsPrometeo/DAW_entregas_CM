package Entrega04;

public class GestorReserva {

        private final Reserva[] reservas;
        private int contador;

        //Constructor
        public GestorReserva(int capacidad) {
            reservas = new Reserva[capacidad];
            contador = 0;
        }

        //Añadir al array
        public void addReserva(Reserva r) {
            if (contador < reservas.length) {
                reservas[contador] = r;
                contador++;
                System.out.println("Reserva guardada.");
            } else {
                System.out.println("No hay espacio disponible para almacenar la reserva.");
            }
        }

        //Mostrar todas las reservas
        public void mostrarTodas() {
            System.out.println("\nMostrando todas las reservas:");
            for (int i = 0; i < contador; i++) {
                System.out.println(reservas[i]);
            }
        }

        //Mostrar por año
        public void mostrarPorAnio(int anio) {
            System.out.println("\nLas reservas del " + anio + " :");

            for (int i = 0; i < contador; i++) {
                if (reservas[i].getFechaReserva().getYear() == anio) {
                    System.out.println(reservas[i]);
                }
            }
        }

        //Mostrar reservas del mes
        public void mostrarPorMes(int mes) {
            System.out.println("\nLas reservas del " + mes + " :");

            for (int i = 0; i < contador; i++) {
                if (reservas[i].getFechaReserva().getMonthValue() == mes) {
                    System.out.println(reservas[i]);
                }
            }
        }

        //Mostrar rango de años
        public void mostrarPorRangoAnios(int inicio, int fin) {
            System.out.println("\nReservas de " + inicio + " hasta " + fin + " :");

            for (int i = 0; i < contador; i++) {
                int anioReserva = reservas[i].getFechaReserva().getYear();

                if (anioReserva >= inicio && anioReserva <= fin) {
                    System.out.println(reservas[i]);
                }
            }
        }
}
