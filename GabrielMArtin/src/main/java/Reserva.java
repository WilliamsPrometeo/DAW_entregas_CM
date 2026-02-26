import java.time.LocalDate;

//esta es la clase que representaa una reserva de hotel
public class Reserva {

    //identificador único de la reserva
    private String idReserva;

    //nombre del cliente
    private String nombreCliente;

    //fecha de la reserva (NO String)
    private LocalDate fechaReserva;

    //tipo de reserva, es el enum
    private TipoReserva tipoReserva;

    //constructor con parámetros
    public Reserva(String idReserva, String nombreCliente,
                   LocalDate fechaReserva, TipoReserva tipoReserva) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
    }





















    //getter del identificador
    public String getIdReserva() {
        return idReserva;
    }

    //setter del identificador
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    //getter del nombre del cliente
    public String getNombreCliente() {
        return nombreCliente;
    }

    //setter del nombre del cliente
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    //getter de la fecha
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    //setter de la fecha
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    //getter del tipo de reserva
    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    //setter del tipo de reserva
    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    //metodo toString sobrescrito para mostrar la información de la reserva
    @Override
    public String toString() {
        return String.format(
                "Reserva [%s] | Cliente: %s | Fecha: %s | Tipo: %s",
                idReserva,
                nombreCliente,
                fechaReserva,
                tipoReserva
        );
    }
}

