package Clases;

import enums.TipoReserva;

import java.time.LocalDate;

public class Reserva {

    private String idReserva;
    private static int contador=0;
    private String nombreCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;

    public Reserva(String nombreCliente, LocalDate fechaReserva, TipoReserva tipoReserva) {
        contador ++;
        this.idReserva = ""+contador;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
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

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", tipoReserva=" + tipoReserva +
                '}';
    }
}
