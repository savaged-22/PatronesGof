package co.patronesgof.fis.models;

public abstract class Ruta {
    protected String codigo;
    protected String nombre;

    public Ruta(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public abstract void mostrarInfo();

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
