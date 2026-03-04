package daw.entregas.GestionBiblioteca;

public abstract class Material {
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Material(String codigo, String titulo, String autor, int anioPublicacion) {

        if (!codigo.matches("[a-zA-Z]{3}[0-9]{2}")) {
            System.out.println("Codigo invalido");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public abstract String mostrarDetalle();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        return this.codigo != null ? this.codigo.equals(material.codigo) : material.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}