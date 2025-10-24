package dominio;

import java.util.List;

public class ExperimentoFisico extends Experimento {
    private String instrumento;
    private List<Investigador> investigadores;

    public ExperimentoFisico(String nombre, int duracion, Boolean resultado, String instrumento, List<Investigador> investigadores) {
        super(nombre, duracion, resultado);
        this.instrumento = instrumento;
        this.investigadores = investigadores;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    @Override
    public String getTipoExperimento() {
        return "Físico";
    }
    @Override
    public String toString(){
        return "Falta rellenar datos";
    }


}
