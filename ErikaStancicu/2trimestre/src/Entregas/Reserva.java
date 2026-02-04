package Entregas;

import Ejemplos.Tipo;

import java.time.LocalDate;

public class Reserva {
    private String IdentificadorReserva;
    private String NombreCli;
    private LocalDate fechaReserva;
    TipoReserva tipoReserva;

    public Reserva(String IdentificadorReserva, String NombreCli, LocalDate fechaReserva,TipoReserva tipoReserva) {
        this.IdentificadorReserva = IdentificadorReserva;
        this.NombreCli = NombreCli;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
    }

    public String getNombreCli() {
        return NombreCli;
    }

    public void setNombreCli(String nombreCli) {
        NombreCli = nombreCli;
    }

    public String getIdentificadorReserva() {
        return IdentificadorReserva;
    }

    public void setIdentificadorReserva(String identificadorReserva) {
        IdentificadorReserva = identificadorReserva;
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
        return String.format("Indentificador Reserva: %10s, Nombre Cliente: %15s, Fecha Reserva: %10s, Tipo Reserva: %10s", IdentificadorReserva, NombreCli, fechaReserva, tipoReserva);
    }
}
