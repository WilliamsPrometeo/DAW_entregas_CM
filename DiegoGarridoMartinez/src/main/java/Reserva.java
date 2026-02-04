import java.time.LocalDate;

public class Reserva {

    //atributos privados
    private String identificador;
    private String nombreCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipo;

    //constructor con todos los datos necesarios
    public Reserva(String identificador, String nombreCliente, LocalDate fechaReserva, TipoReserva tipo) {
        this.identificador = identificador;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.tipo = tipo;
    }

    //
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

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    //representamos en texto la reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "ID='" + identificador + '\'' +
                ", Cliente='" + nombreCliente + '\'' +
                ", Fecha=" + fechaReserva +
                ", Tipo=" + tipo +
                '}';
    }
}
