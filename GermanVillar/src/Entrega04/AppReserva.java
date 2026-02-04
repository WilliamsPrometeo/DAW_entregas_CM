package Entrega04;

import java.time.LocalDate;

public class AppReserva {
    public static void main(String[] args) {

        GestorReserva gestor = new GestorReserva(30);

        // Añadir reservas
        gestor.addReserva(new Reserva("RSV001","Carlos Alcaraz",LocalDate.of(2024, 5, 10), TipoReserva.DOBLE));
        gestor.addReserva(new Reserva("RSV002","Paula Garcia",LocalDate.of(2025, 9, 18), TipoReserva.INDIVIDUAL));
        gestor.addReserva(new Reserva("RSV003","Joan Forest",LocalDate.of(2026, 1, 21), TipoReserva.SUITE));


        //Mostrar todas las reservas
            gestor.mostrarTodas();
        //Mostrar por año
            gestor.mostrarPorAnio(2025);
        //Mostrar por mes
            gestor.mostrarPorMes(1);
        //Mostrar por rango
            gestor.mostrarPorRangoAnios(2023, 2026);
    }
}
