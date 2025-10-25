package dominio;

public class ExperimentoQuimico extends Experimento {
    private String tipoReactivo;
    private Investigador investigador;


    public ExperimentoQuimico(String nombre, int duracion, Boolean resultado, String tipoReactivo, Investigador investigador) {
        super(nombre, duracion, resultado);
        this.tipoReactivo= tipoReactivo;
        this.investigador= investigador;
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }

    public void setTipoReactivo(String tipoReactivo) {
        this.tipoReactivo = tipoReactivo;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    @Override
    public String getTipoExperimento(){
        return "Químico";
    }

    @Override
    public String toString(){
        return "Experimento Químico [nombre= "+getNombre()+", duración= "+getDuracion()+
                ", resultado= "+ (getResultado()?"Éxito":"Fallo")+ ", tipo Reactivo= "+ tipoReactivo+
                ", Investigador= "+investigador.getNombre()+"]";

    }
}
