package clases;

public abstract class Material
{
    //ATRIBUTOS
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    //CONSTRUCTOR
    public Material(String codigo, String titulo, String autor, int anioPublicacion)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    //GETTERS Y SETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    //METODOS
    public abstract String mostrarDetalle();

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Material v = (Material) obj;

        return this.codigo != null ? this.codigo.equals(v.codigo) : v.codigo == null;
    }


}
