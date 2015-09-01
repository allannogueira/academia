package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */

import java.util.List;

/**
 * Table(neme="exercicios")
 */
public class ExercicioTO {

    private Long codExercicio;

    private String nmeExercicio;

    private String finalidade;

    //Campo como_fazer
    private String dscDetalhes;

    private boolean arLiver;

    private List<ExercicioTreinoTO> listaExercicioTreinoTO;

    public Long getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(Long codExercicio) {
        this.codExercicio = codExercicio;
    }

    public String getNmeExercicio() {
        return nmeExercicio;
    }

    public void setNmeExercicio(String nmeExercicio) {
        this.nmeExercicio = nmeExercicio;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getDscDetalhes() {
        return dscDetalhes;
    }

    public void setDscDetalhes(String dscDetalhes) {
        this.dscDetalhes = dscDetalhes;
    }

    public boolean isArLiver() {
        return arLiver;
    }

    public void setArLiver(boolean arLiver) {
        this.arLiver = arLiver;
    }

    public List<ExercicioTreinoTO> getListaExercicioTreinoTO() {
        return listaExercicioTreinoTO;
    }

    public void setListaExercicioTreinoTO(List<ExercicioTreinoTO> listaExercicioTreinoTO) {
        this.listaExercicioTreinoTO = listaExercicioTreinoTO;
    }
}