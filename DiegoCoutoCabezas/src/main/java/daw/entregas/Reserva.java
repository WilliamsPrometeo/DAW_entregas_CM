package daw.entregas;

import java.time.LocalDate;

public class Reserva {

    //Ponemos todas en private ya que es lo que nos dice el enunciado
    private String identificador;
    private String nombreCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;

    public Reserva(String identificador, String nombreCliente, LocalDate fechaReserva, TipoReserva tipoReserva) {
        this.identificador = identificador;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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
        return "Reserva{ " +
                "identificador ='" + identificador + '\'' +
                ", nombreCliente ='" + nombreCliente + '\'' +
                ", fechaReserva =" + fechaReserva +
                ", tipoReserva =" + tipoReserva +
                '}';

    }
}
