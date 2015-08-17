package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="exercicios_has_treino")
 */
public class ExercicioTreinoTO {

    private List<ExercicioTO> listaExercicioTO;

    private List<TreinoAlunoTO> listaTreinoAluno;

    public List<ExercicioTO> getListaExercicioTO() {
        return listaExercicioTO;
    }

    public void setListaExercicioTO(List<ExercicioTO> listaExercicioTO) {
        this.listaExercicioTO = listaExercicioTO;
    }

    public List<TreinoAlunoTO> getListaTreinoAluno() {
        return listaTreinoAluno;
    }

    public void setListaTreinoAluno(List<TreinoAlunoTO> listaTreinoAluno) {
        this.listaTreinoAluno = listaTreinoAluno;
    }
}
