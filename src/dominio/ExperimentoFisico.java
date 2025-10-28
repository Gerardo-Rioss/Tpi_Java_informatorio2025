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

//    StringBuilder es una clase en Java utilizada para construir cadenas de texto de manera eficiente,
//    especialmente cuando se concatenan múltiples cadenas en un bucle. A diferencia de usar el operador +
//    con objetos String (que crea nuevos objetos cada vez), StringBuilder modifica la misma cadena en memoria,
//    lo que lo hace más eficiente.

    @Override
    public String toString(){
        StringBuilder nombresInvestigadores = new StringBuilder();
        for (Investigador inv: investigadores){
            nombresInvestigadores.append(inv.getNombre()).append(", ");
        }
        return "Experimento Físico [nombre= "+getNombre()+", duración= "+ getDuracion()+
                ", resultado= "+(getResultado()?"Éxito":"Fallo")+
                ", instrumento= "+instrumento+
                ", investigador= "+nombresInvestigadores.toString()+",";
    }


}
