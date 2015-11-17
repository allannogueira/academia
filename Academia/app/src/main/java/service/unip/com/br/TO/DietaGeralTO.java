package service.unip.com.br.TO;

import java.util.List;

/**
 * Created by Cleber on 15/08/2015.
 */
/**
 * Table(neme="dieta_geral")
 */
public class DietaGeralTO {

    private Long codDieta;

    private String nmeDieta;

    private String finalidade;

    private List<AlimentoTO> listaAlimentoTO;

    public Long getCodDieta() {
        return codDieta;
    }

    public void setCodDieta(Long codDieta) {
        this.codDieta = codDieta;
    }

    public String getNmeDieta() {
        return nmeDieta;
    }

    public void setNmeDieta(String nmeDieta) {
        this.nmeDieta = nmeDieta;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public List<AlimentoTO> getListaAlimentoTO() {
        return listaAlimentoTO;
    }

    public void setListaAlimentoTO(List<AlimentoTO> listaAlimentoTO) {
        this.listaAlimentoTO = listaAlimentoTO;
    }
}
