package Entrega04;

import java.time.LocalDate;

public class Reserva {

    //Atributos
    private String identificador;
    private String nombre;
    private LocalDate fechaReserva;
    private TipoReserva tipo;

    //Constructor
    public Reserva(String identificador, String nombre, LocalDate fechaReserva, TipoReserva tipo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fechaReserva = fechaReserva;
        this.tipo = tipo;
    }


    //Getters y setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombreCliente() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", tipo=" + tipo +
                '}';
    }
}

