package src;

import java.time.LocalDate;

public class Reserva {

    private String idReserva;
    private String cliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;

    public Reserva(String idReserva, String cliente, LocalDate fechaReserva, TipoReserva tipoReserva) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
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

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
    return String.format("Registro: %8s, fecha de creación %10s, tipo: %s, cliente: %s", idReserva, fechaReserva, tipoReserva, cliente);
    }
}
