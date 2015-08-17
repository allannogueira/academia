package service.unip.com.br.TO;

/**
 * Created by Cleber on 15/08/2015.
 */

import java.util.List;

/**
 * Table(neme="aluno")
 */
public class AlunoTO {

    private Long codAluno;

    private String nmeAluno;

    private TreinoAlunoTO treinoAlunoTO;

    private MedidasAlunoTO medidasAlunoTO;

    private String numCpf;

    private String numRg;

    private DietaAlunoTO dietaAlunoTO;

    private String dscEmail;

    private String objTreino;

    private EnderecoTO enderecoAluno;

    private List<ExercicioArLivreTO> listaExercicioArLivreTO;

    private List<AlunoAcademiaTO> listaAlunoAcademiaTO;

    public Long getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Long codAluno) {
        this.codAluno = codAluno;
    }

    public String getNmeAluno() {
        return nmeAluno;
    }

    public void setNmeAluno(String nmeAluno) {
        this.nmeAluno = nmeAluno;
    }

    public TreinoAlunoTO getTreinoAlunoTO() {
        return treinoAlunoTO;
    }

    public void setTreinoAlunoTO(TreinoAlunoTO treinoAlunoTO) {
        this.treinoAlunoTO = treinoAlunoTO;
    }

    public MedidasAlunoTO getMedidasAlunoTO() {
        return medidasAlunoTO;
    }

    public void setMedidasAlunoTO(MedidasAlunoTO medidasAlunoTO) {
        this.medidasAlunoTO = medidasAlunoTO;
    }

    public String getNumCpf() {
        return numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public String getNumRg() {
        return numRg;
    }

    public void setNumRg(String numRg) {
        this.numRg = numRg;
    }

    public DietaAlunoTO getDietaAlunoTO() {
        return dietaAlunoTO;
    }

    public void setDietaAlunoTO(DietaAlunoTO dietaAlunoTO) {
        this.dietaAlunoTO = dietaAlunoTO;
    }

    public String getDscEmail() {
        return dscEmail;
    }

    public void setDscEmail(String dscEmail) {
        this.dscEmail = dscEmail;
    }

    public String getObjTreino() {
        return objTreino;
    }

    public void setObjTreino(String objTreino) {
        this.objTreino = objTreino;
    }

    public EnderecoTO getEnderecoAluno() {
        return enderecoAluno;
    }

    public void setEnderecoAluno(EnderecoTO enderecoAluno) {
        this.enderecoAluno = enderecoAluno;
    }

    public List<ExercicioArLivreTO> getListaExercicioArLivreTO() {
        return listaExercicioArLivreTO;
    }

    public void setListaExercicioArLivreTO(List<ExercicioArLivreTO> listaExercicioArLivreTO) {
        this.listaExercicioArLivreTO = listaExercicioArLivreTO;
    }

    public List<AlunoAcademiaTO> getListaAlunoAcademiaTO() {
        return listaAlunoAcademiaTO;
    }

    public void setListaAlunoAcademiaTO(List<AlunoAcademiaTO> listaAlunoAcademiaTO) {
        this.listaAlunoAcademiaTO = listaAlunoAcademiaTO;
    }
}
