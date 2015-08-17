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

    private Date dataInicio;

    private Date dataFim;

    private DietaGeralTO dietaGeralTO;

    public Long getCodDietaAluno() {
        return codDietaAluno;
    }

    public void setCodDietaAluno(Long codDietaAluno) {
        this.codDietaAluno = codDietaAluno;
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

    public DietaGeralTO getDietaGeralTO() {
        return dietaGeralTO;
    }

    public void setDietaGeralTO(DietaGeralTO dietaGeralTO) {
        this.dietaGeralTO = dietaGeralTO;
    }
}
