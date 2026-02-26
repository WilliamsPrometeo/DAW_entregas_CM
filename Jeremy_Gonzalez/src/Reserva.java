import java.time.LocalDate;

public class Reserva {
    private String identificador;
    private String nombreCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;

    public Reserva(String id, String cliente, LocalDate fecha, TipoReserva tipo) {

        this.identificador = id;
        this.nombreCliente = cliente;
        this.fechaReserva = fecha;
        this.tipoReserva = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void getFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + identificador + '\'' +
                ", cliente='" + nombreCliente + '\'' +
                ", fecha=" + fechaReserva +
                ", tipo=" + tipoReserva +
                '}';
    }

}
