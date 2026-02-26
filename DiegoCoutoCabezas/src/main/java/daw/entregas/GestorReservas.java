package daw.entregas;

public class GestorReservas {

    private Reserva[] reservas;
    private int contador;

    public GestorReservas(int capacidad) {
        reservas = new Reserva[capacidad];
        contador = 0;
    }


    public void mostrarTodas() {
        if (contador == 0) {
            System.out.println("No quedan reservas.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(reservas[i]);
        }
    }

    public void agregarReserva(Reserva res) {
        if (contador < reservas.length) {
            reservas[contador] = res;
            contador++;
            System.out.println("Reserva añadida correctamente.");

        } else {
            System.out.println("No hay espacio para reservas.");
        }
    }


    public void mostrarPorAnio(int ani) {
        boolean encontrada = false;
        for (int i = 0; i < contador; i++) {
            if (reservas[i].getFechaReserva().getYear() == ani) {
                System.out.println(reservas[i]);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay reservas en ese año que pones.");
        }
    }

    public void mostrarPorMes(int mes) {
        boolean encontrada = false;
        for (int i = 0; i < contador; i++) {
            if (reservas[i].getFechaReserva().getMonthValue() == mes) {
                System.out.println(reservas[i]);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay reservas en ese mes.");
        }
    }

    public void mostrarRangoAnios(int inicio, int fin) {
        boolean encontrada = false;
        for (int i = 0; i < contador; i++) {
            int ani = reservas[i].getFechaReserva().getYear();
            if (ani >= inicio && ani <= fin) {
                System.out.println(reservas[i]);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No hay reservas en ese rango de tiempo.");
        }
    }
}
