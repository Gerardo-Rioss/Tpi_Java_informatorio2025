package dominio;

public abstract class Experimento {
    private String nombre;
    private int duracion;
    private Boolean resultado;

    public Experimento(String nombre, int duracion, Boolean resultado) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.resultado = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    public abstract String getTipoExperimento();
}
