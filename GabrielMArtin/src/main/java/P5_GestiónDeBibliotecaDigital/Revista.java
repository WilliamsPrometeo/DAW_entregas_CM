package P5_GestiónDeBibliotecaDigital;

//Clase que representa una Revista. Es heredada de Material.
public class Revista extends Material {

    private int numeroEdicion;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    //mostrar detalle de la revista
    @Override
    public String mostrarDetalle() {
        return String.format(
                "REVISTA -> Código: %s | Título: %s | Autor: %s | Año: %d | Edición: %d",
                getCodigo(),
                getTitulo(),
                getAutor(),
                getAnioPublicacion(),
                numeroEdicion
        );
    }
}