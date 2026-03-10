package daw.entregas.practica5;

public class Revista extends Material{
    
    private int numeroEdicion;
    
    public Revista(String codigo, String titulo, String autor, int anioPublicacion){
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = getNumeroEdicion();
    }
    
    public int getNumeroEdicion() {
        return numeroEdicion;
    }
    
    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
    
    @Override
    public String mostrarDetalle() {
        return String.format("Libro: %s, %s, %s, %d, %d",
            super.getCodigo(),
            super.getTitulo(),
            super.getAutor(),
            super.getAnioPublicacion(),
            this.getNumeroEdicion());
    }
}
