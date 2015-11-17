package service.unip.com.br.TO;

import java.util.Date;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="dieta")
 */
public class DietaAlunoTO {

    private Long codDietaAluno;

    private String dataInicio;

    private String dataFim;

    private DietaGeralTO dietaGeralTO;

    public Long getCodDietaAluno() {
        return codDietaAluno;
    }

    public void setCodDietaAluno(Long codDietaAluno) {
        this.codDietaAluno = codDietaAluno;
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

    public DietaGeralTO getDietaGeralTO() {
        return dietaGeralTO;
    }

    public void setDietaGeralTO(DietaGeralTO dietaGeralTO) {
        this.dietaGeralTO = dietaGeralTO;
    }
}
