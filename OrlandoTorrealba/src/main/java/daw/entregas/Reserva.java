package daw.entregas;

import java.time.LocalDate;

    public class Reserva {
        
        private String identificador;
        private String nombreCliente;
        private LocalDate fechaReserva;
        private TipoReserva horaReserva;
        
        
        public Reserva(String identificador, String nombreCliente, LocalDate fechaReserva, TipoReserva horaReserva) {
            this.identificador = identificador;
            this.nombreCliente = nombreCliente;
            this.fechaReserva = fechaReserva;
            this.horaReserva = horaReserva;
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
        
        public TipoReserva getHoraReserva() {
            return horaReserva;
        }
        
        public void setHoraReserva(TipoReserva horaReserva) {
            this.horaReserva = horaReserva;
        }
        
        @Override
        public String toString() {
            return "Reserva" + "identificador ='" + identificador + '\'' + ", nombreCliente='" + nombreCliente + '\'' + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + '}';
        }
    }