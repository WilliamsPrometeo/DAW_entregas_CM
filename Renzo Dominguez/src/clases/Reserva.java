package clases;

import enums.TipoReserva;

import java.time.LocalDate;

public class Reserva
{
    //ATRIBUTOS
    private String reservaID;
    private String nombreCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;

    //CONSTRUCTOR
    public Reserva(String reservaID, String nombreCliente, LocalDate fechaReserva, TipoReserva tipoReserva) {
        this.reservaID = reservaID;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
    }

    //GETTERS Y SETTERS

    public String getReservaID() {
        return reservaID;
    }

    public void setReservaID(String reservaID) {
        this.reservaID = reservaID;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    //toString
    @Override
    public String toString() {
        return String.format("Reserva-> Tipo: %8s, fecha de reserva: %10s, cliente: %s, reserva ID ",  tipoReserva, fechaReserva, nombreCliente, reservaID);
    }
}
