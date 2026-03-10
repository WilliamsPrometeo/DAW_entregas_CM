package daw.entregas.clases;

public class Revista extends Material{
    //Atributo

    private int numeroEdicion;

    //Constructor

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    //Getter y Setter

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    //Metodo

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