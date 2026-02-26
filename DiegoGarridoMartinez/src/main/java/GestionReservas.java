public class GestionReservas {

    private Reserva[] reservas;
    private int contador;

    // constructor que define la capacidad máxima
    public GestionReservas(int capacidad) {
        reservas = new Reserva[capacidad];
        contador = 0;
    }

    // añade una reserva si hay espacio disponible
    public boolean anadirReserva(Reserva r) {
        if (contador < reservas.length) {
            reservas[contador] = r;
            contador++;
            return true;
        }
        return false;
    }

    //muestra todas las reservas
    public void mostrarTodas() {
        if (contador == 0) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            System.out.println(reservas[i]);
        }
    }

    // muestra reservas de un año concreto
    public void filtrarPorAnio(int anio) {
        for (int i = 0; i < contador; i++) {
            if (reservas[i].getFechaReserva().getYear() == anio) {
                System.out.println(reservas[i]);
            }
        }
    }

    //muestra reservas de un mes concreto
    public void filtrarPorMes(int mes) {
        for (int i = 0; i < contador; i++) {
            if (reservas[i].getFechaReserva().getMonthValue() == mes) {
                System.out.println(reservas[i]);
            }
        }
    }
    // muestra reservas entre dos años
    public void filtrarPorRangoAnios(int inicio, int fin) {
        for (int i = 0; i < contador; i++) {
            int anioReserva = reservas[i].getFechaReserva().getYear();
            if (anioReserva >= inicio && anioReserva <= fin) {
                System.out.println(reservas[i]);
            }
        }
    }
}
