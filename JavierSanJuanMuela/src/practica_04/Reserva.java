package practica_04;

// JAVIER SAN JUAN MUELA

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private String idReserva;
    private String cliente;
    private LocalDate fechaReserva;
    private String tipoReservaValue;

    public enum TipoReserva {INDIVIDUAL, DOBLE, SUITE}

    public Reserva(String idReserva, String cliente, LocalDate fechaReserva, String tipoReservaValue) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        this.tipoReservaValue = tipoReservaValue;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getTipoReservaValue() {
        return tipoReservaValue;
    }

    public void setTipoReservaValue(String tipoReservaValue) {
        this.tipoReservaValue = tipoReservaValue;
    }

    @Override
    public String toString() {
        return String.format("ID Reserva: %s - Cliente: %s - Fecha de la Reserva: %s - Tipo de Habitación: %s", idReserva, cliente, DateTimeFormatter.ofPattern("YYYY/MM/DD").format(fechaReserva), tipoReservaValue);
    }
}
