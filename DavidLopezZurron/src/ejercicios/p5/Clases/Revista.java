package ejercicios.p5.Clases;

public class Revista extends Material {
    //Atributos
    private int numeroEdicion;
    
    //Constructor
    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }
    
    //Getters y setters
    public int getNumeroEdicion() {
        return numeroEdicion;
    }
    
    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
    
    //Metodos
    @Override
    public String mostrarDetalle() {
        return String.format("""
            Los detalles de la revista son:
            Código: %s
            Titulo: %s
            Autor: %s
            Año de publicación: %d
            Numero de edición: %d""", super.getCodigo(), super.getTitulo(), super.getAutor(), super.getAnioPublicacion(), this.numeroEdicion);
    }
}
