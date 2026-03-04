package P5_GestiónDeBibliotecaDigital;

//CLASE ABSTRACTA que representa un material de la biblioteca. Y contiene los atributos comunes a todos los materialess
public abstract class Material {

    //ATRIBUTOS
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    //CONTRUCTOR de la clase Material
    public Material(String codigo, String titulo, String autor, int anioPublicacion) {
        // El código siempre se almacena en mayúsculas
        this.codigo = codigo.toUpperCase();
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    //GETTERS, no añado setters para evitar modificar el código
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

    //MÉTODO ABSTRACTO que en cada subclase tengo que implementar
    public abstract String mostrarDetalle();

    //HASHCODE se basa en el código, es obligatorio para que funcione correctamente como en un Map
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    //EQUALS que se basa únicamente en el código. Dos materiales entonces son iguales si tienen el mismo códigoo
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Material other = (Material) obj;

        return this.codigo != null ?
                this.codigo.equals(other.codigo)
                : other.codigo == null;
    }
}
