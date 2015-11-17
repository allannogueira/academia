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

    private String dataInicio;

    private String dataFim;

    private String datCadastro;

    private List<ExercicioTO> listaExercicioTO;

    private String serie;

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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public List<ExercicioTO> getListaExercicioTO() {
        return listaExercicioTO;
    }

    public void setListaExercicioTO(List<ExercicioTO> listaExercicioTO) {
        this.listaExercicioTO = listaExercicioTO;
    }

    public String getDatCadastro() {
        return datCadastro;
    }

    public void setDatCadastro(String datCadastro) {
        this.datCadastro = datCadastro;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
