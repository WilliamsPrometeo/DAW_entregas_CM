package daw.entregas.practica5;

public  abstract class Revista extends Material {
    //ATRIBUTOS
    int numeroEdicion;

    //CONSTRUCTOR
    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    //GETTERS
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    //SETTERS
    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    //MÉTODOS
    //MÉTODO ABSTRACTO QUE MUESTRA LA INFORMACIÓN DE LA REVISTA
    public abstract String mostrarDetalle();
}
