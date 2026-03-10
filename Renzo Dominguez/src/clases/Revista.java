package clases;

public class Revista extends Material
{
    //ATRIBUTO
    private int numeroEdicion;

    //CONSTRUCTOR
    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    //GETTERS Y SETTERS
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    //METODOS
    @Override
    public String mostrarDetalle()
    {
        return String.format("Libro: %s, %s, %s, %d, %d",
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion(),
                this.getNumeroEdicion());
    }
}
