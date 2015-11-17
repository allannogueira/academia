package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="exercicios_has_treino")
 */
public class ExercicioTreinoTO {

    private String codExercicioTO;

    private String codTreinoAluno;

    private String peso;

    public String getCodExercicioTO() {
        return codExercicioTO;
    }

    public void setCodExercicioTO(String codExercicioTO) {
        this.codExercicioTO = codExercicioTO;
    }

    public String getCodTreinoAluno() {
        return codTreinoAluno;
    }

    public void setCodTreinoAluno(String codTreinoAluno) {
        this.codTreinoAluno = codTreinoAluno;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
