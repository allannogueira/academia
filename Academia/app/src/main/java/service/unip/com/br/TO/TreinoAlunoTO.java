package service.unip.com.br.TO;

import java.util.Date;
import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="treino")
 */
public class TreinoAlunoTO {

    private Long codTreinoAluno;

    private String nmeTreino;

    private Date dataInicio;

    private Date dataFim;

    private List<ExercicioTreinoTO> listaExercicioTreinoTO;

    public Long getCodTreinoAluno() {
        return codTreinoAluno;
    }

    public void setCodTreinoAluno(Long codTreinoAluno) {
        this.codTreinoAluno = codTreinoAluno;
    }

    public String getNmeTreino() {
        return nmeTreino;
    }

    public void setNmeTreino(String nmeTreino) {
        this.nmeTreino = nmeTreino;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<ExercicioTreinoTO> getListaExercicioTreinoTO() {
        return listaExercicioTreinoTO;
    }

    public void setListaExercicioTreinoTO(List<ExercicioTreinoTO> listaExercicioTreinoTO) {
        this.listaExercicioTreinoTO = listaExercicioTreinoTO;
    }
}
