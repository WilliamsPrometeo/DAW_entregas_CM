package ejercicios.p4.Clases;

import ejercicios.p4.Enum.TipoReserva;

import java.time.LocalDate;

public class Reserva {
    //Atributos
    private String id;
    private static int numReserva = 0;
    private String nombreCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;
    
    //Constructor
    public Reserva(String nombreCliente, LocalDate fechaReserva, TipoReserva tipoReserva) {
        //Ponemos numReserva más uno ya que no tiene sentido humano empezar en la reserva 0
        this.id = "Reserva " + (numReserva + 1);
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
        //Sumamos uno a la reserva, ya que además de usarlo para el id, será nuestro contador para saber cuantas
        //reservas llevamos, además de para establecer un límite en los bucles for
        numReserva++;
    }
    
    //Getters y setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
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
    
    public static int getNumReserva() {
        return numReserva;
    }
    
    public static void setNumReserva(int numReserva) {
        Reserva.numReserva = numReserva;
    }
    
    //ToString
    
    @Override
    public String toString() {
        return String.format("""
                %s:
                Nombre cliente = %s
                FechaReserva = %10s
                Tipo de la reserva: %10s
            
            """, id, nombreCliente, fechaReserva, tipoReserva);
    }
}
